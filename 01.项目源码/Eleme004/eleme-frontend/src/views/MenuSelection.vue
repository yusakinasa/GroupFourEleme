<template>
  <div class="eleme-page">
    <!-- 使用 HeaderBar 组件 -->
    <header class="header">
      <button class="logo-btn" @click="logoclick">
        <img src="../assets/eleme-logo.png" alt="Eleme Logo" class="logo"/>
        <h1>ELEME</h1>
      </button>
      <div class="search-bar">
        <input type="text" placeholder="搜索" v-model="searchQuery" @keyup.enter="search">
        <button @click="search">搜索</button>
      </div>
      <div class="user-info">
        <span>{{ userPhone }}</span>
        <button @click="viewOrders">我的订单</button>
        <button @click="logout">退出</button>
      </div>
    </header>
    <div class="menu-page">
      <!-- 主内容区域 -->
      <div class="content" v-if="currentStore && Object.keys(currentStore).length > 0">

        <!-- 左边展示区域 -->
        <div class="left-view">
          <div class="shop-info-container">
            <div class="shop-info">
              <h2>{{ currentStore.name }}</h2>
              <p>地址: {{ currentStore.address }}</p>
              <p>电话: {{ currentStore.phone }}</p>
              <p>评分: {{ currentStore.rating }} | 人均: {{ currentStore.avgprice }}元 | 月销量: {{ currentStore.sales }}+</p>
              <p>公告: {{ currentStore.notice }}</p>
            </div>
            <div class="shop-image">
              <img :src="currentStore.imageurl" alt="店铺图片">

              <!--              <h2>{{ currentStore.name }}</h2>-->
              <!--              <p>地址: {{ currentStore.address }}</p>-->
              <!--              <p>电话: {{ currentStore.phone }}</p>-->
              <!--              <p>评分: {{ currentStore.rating }} | 人均: {{ currentStore.avgprice }}元 | 月销量: {{ currentStore.sales }}+</p>-->
              <!--              <p>公告: {{ currentStore.notice }}</p>-->
              <!--            </div>-->
              <!--            <div class="shop-image">-->
              <!--              <img :src="currentStore.imageurl" alt="店铺图片">-->

            </div>
          </div>
<!--          <div class="menu-tabs">-->
<!--          <span-->
<!--              v-for="tab in tabs"-->
<!--              :key="tab"-->
<!--              :class="{ active: currentTab === tab }"-->
<!--              @click="currentTab = tab"-->
<!--          >-->
<!--            {{ tab }}-->
<!--          </span>-->
<!--          </div>-->
          <div class="menu-content">
            <div v-if="currentTab === '推荐菜'" class="recommendation-section">
              <div class="menu-items">
                <div class="menu-item" v-for="item in filteredMenuItems" :key="item.foodid">
                  <img :src="item.imageurl" :alt="item.name" style="max-width: 50%; max-height: 50%;">
                  <div class="item-details">
                    <h3>{{ item.name }}</h3>
                    <p>¥{{ item.price }}</p>
                    <div class="quantity-control">
                      <button @click="decreaseQuantity(item)">-</button>
                      <span>{{ item.quantity }}</span>
                      <button @click="increaseQuantity(item)">+</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div v-else class="other-section">
              <p>{{ currentTab }}内容展示</p>
            </div>
          </div>
        </div>

        <!-- 购物车区域 -->
        <div class="cart">
          <h3>已选商品</h3>
          <div class="cart-items">
            <div class="cart-item" v-for="item in cartItems" :key="item.foodid">
              <img :src="item.imageurl" alt="item.name">
              <div class="item-details">
                <h4>{{ item.name }}</h4>
                <p>¥{{ item.price }} x {{ item.quantity }}</p>
                <div class="quantity-control">
                  <button @click="decreaseQuantity(item)">-</button>
                  <span>{{ item.quantity }}</span>
                  <button @click="increaseQuantity(item)">+</button>
                </div>
              </div>
            </div>
          </div>

        <div class="total">
          <span>共计 {{ totalPrice }} ¥</span>
          <button @click="checkout">去结算</button>

        </div>
        </div>
      </div>
</div>
  </div>
</template>

<!--      <div v-else>-->
<!--        &lt;!&ndash; 加载或错误处理 &ndash;&gt;-->
<!--        <p v-if="loading">加载中...</p>-->
<!--        <p v-else>无法加载商家信息。</p>-->
<!--      </div>-->

<script>
import axios from 'axios';

export default {
  name: 'MenuSelection',
  data() {
    return {
      currentStore: {},
      tabs: ['推荐菜', '环境', '价目表', '官方相册', '品牌故事', '食品安全档案'],
      currentTab: '推荐菜',
      menuItems: [],
      filteredMenuItems: [],
      cartItems: [],
      userPhone: '',
      loading: true,
      searchQuery: ''
    };
  },
  computed: {
    totalPrice() {
      return this.cartItems.reduce((total, item) => total + item.price * item.quantity, 0);
    }
  },
  methods: {
    logoclick() {
      this.$router.push({name: 'ShopSelection'});
    },
    checkout() {
      const selectedItems = JSON.stringify(this.cartItems); // 传递 cartItems，其中包含数量信息和食物信息
      const storeName = this.currentStore.name; // 获取商家店名
      this.$router.push({
        name: 'OrderConfirm',
        query: {
          items: selectedItems,
          storeName: storeName
        }
      });
    },
    addToCart(item) {
      axios.post(`http://localhost:8080/api/cart-item/add`, {
        foodid: item.foodid,
        quantity: item.quantity
      })
          .then(() => {
            // 添加成功后更新视图或其他逻辑
            // 例如从数据库获取最新的购物车信息
          })
          .catch(error => {
            console.error('添加商品到购物车失败:', error);
          });
    },
    removeFromCart(cartitemid) {
      axios.delete(`http://localhost:8080/api/cart-item/remove/${cartitemid}`)
          .then(() => {
            // 移除成功后更新视图或其他逻辑
            // 例如从数据库获取最新的购物车信息
          })
          .catch(error => {
            console.error('从购物车移除商品失败:', error);
          });
    },
    fetchStoreDetails(businessid) {
      axios.get(`http://localhost:8081/business/${businessid}`)
          .then(response => {
            this.currentStore = response.data;
            this.fetchMenuItems(businessid);
            this.loading = false;
          })
          .catch(error => {
            console.error('获取店铺详情失败:', error);
            this.loading = false;
          });
    },
    fetchMenuItems(businessid) {
      axios.get(`http://localhost:8081/food/business/${businessid}`)
          .then(response => {
            this.menuItems = response.data.map(item => ({
              ...item,
              quantity: 0
            }));
            this.filteredMenuItems = this.menuItems;
          })
          .catch(error => {
            console.error('获取菜单失败:', error);
          });
    },
    search() {
      const query = this.searchQuery.toLowerCase();
      this.filteredMenuItems = this.menuItems.filter(item => item.name.toLowerCase().includes(query));
    },
    increaseQuantity(item) {
      item.quantity++;
      if (!this.cartItems.includes(item)) {
        this.cartItems.push(item);
      }
    },
    decreaseQuantity(item) {
      if (item.quantity > 0) {
        item.quantity--;
        if (item.quantity === 0) {
          const index = this.cartItems.indexOf(item);
          if (index !== -1) {
            this.cartItems.splice(index, 1);
          }
        }
      }
    },
    logout() {
      localStorage.removeItem('userPhone');
      this.$router.push({ name: 'LogIn' });
    }
  },
  created() {
    const businessid = this.$route.query.businessid;
    this.fetchStoreDetails(businessid);
    this.userPhone = localStorage.getItem('userPhone');
  }
};
</script>

<style scoped>
.menu-page {
  font-family: Arial, sans-serif;
  margin: 0 10%;
  padding: 20px;
}
.menu-selection {
  display: flex;
  flex-direction: column;
  height: 100vh;
}

.content {
  display: flex;
  flex: 1;
  overflow: hidden;
}

.left-view {
  flex: 3;
  padding: 1rem;
  overflow-y: auto;
}

.menu-tabs {
  display: flex;
  margin-bottom: 1rem;
}

.menu-tabs span {
  margin-right: 1rem;
  cursor: pointer;
}

.menu-tabs .active {
  font-weight: bold;
}

.menu-content {
  background-color: #f0f0f0; /* 灰色背景 */
  padding: 20px;
  border-radius: 8px;
}

.menu-items {
  display: flex;
  flex-wrap: wrap;
  gap: 20px; /* 间距 */
}

.menu-item {
  flex: 1 1 calc(40% - 20px); /* 每行两个 */
  background-color: #fff;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  overflow: hidden;
  text-align: center;
  padding: 1rem;
}

.menu-item img {
  width: 100%;
  height: auto;
}

.menu-item .item-details {
  margin-top: 0.5rem;
}

.cart {
  flex: 1;
  padding: 1rem;
  background-color: #f8f8f8;
  border-left: 1px solid #e0e0e0;
  display: flex;
  flex-direction: column;
}

.cart-items {
  flex: 1;
  overflow-y: auto;
}

.cart-item {
  display: flex;
  align-items: center;
  padding: 0.5rem 0;
}

.cart-item img {
  height: 50px;
  margin-right: 1rem;
}

.cart .total {
  display: flex;
  justify-content: space-between;
  padding-top: 1rem;
}

.quantity-control button {
  margin: 0 0.5rem;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.shop-info-container {
  display: flex;
  align-items: flex-start;
}

.shop-info {
  flex: 1;
}



.shop-img img {
  width: 100%;
  height: auto;
  border-radius: 8px;
}

.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: #f0f0f0;
  padding: 16px;
  margin-bottom: 16px;
  border-radius: 8px;
}

.logo {
  height: 40px;
  width: 40px;
}

.search-bar {
  display: flex;
  align-items: center;
}

.search-bar input {
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.search-bar button {
  padding: 0.5rem;
  margin-left: 0.5rem;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.user-info {
  display: flex;
  align-items: center;
}

.user-info button {
  margin-left: 0.5rem;
  padding: 0.5rem;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

h1 {
  margin: 10px;
  font-size: 24px;
  color: #333;
}

.logo-btn {
  cursor: pointer;
  border: none;
  display: flex;
  background-color: #f0f0f0;
}
</style>