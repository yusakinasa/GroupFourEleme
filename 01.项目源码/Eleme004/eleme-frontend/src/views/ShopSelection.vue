<!--<template>-->
<!--  &lt;!&ndash; 使用 HeaderBar 组件 &ndash;&gt;-->
<!--&lt;!&ndash;  <HeaderBar&ndash;&gt;-->
<!--&lt;!&ndash;      :username="username"&ndash;&gt;-->
<!--&lt;!&ndash;      @logo-click="onLogoClick"&ndash;&gt;-->
<!--&lt;!&ndash;      @search="onSearch"&ndash;&gt;-->
<!--&lt;!&ndash;      @view-orders="onViewOrders"&ndash;&gt;-->
<!--&lt;!&ndash;      @logout="onLogout"&ndash;&gt;-->
<!--&lt;!&ndash;  />&ndash;&gt;-->


<!--  <div class="eleme-page">-->
<!--    <header class="header">-->
<!--      <div class="logo">-->
<!--        <img src="logo.png" alt="ELEME">-->
<!--        <span>ELEME</span>-->
<!--      </div>-->
<!--      <div class="search-bar">-->
<!--        <input type="text" placeholder="搜索" v-model="searchQuery">-->
<!--        <button @click="searchStores">搜索</button>-->
<!--      </div>-->
<!--      <div class="user-info">-->
<!--        <span>{{ userPhone }}</span>-->
<!--        <button>我的订单</button>-->
<!--        <button @click="logout">退出</button>-->
<!--      </div>-->
<!--    </header>-->

<!--    <nav class="navigation">-->
<!--      <button-->
<!--          v-for="(button, index) in buttons"-->
<!--          :key="index"-->
<!--          :class="{ active: button.isActive }"-->
<!--          @click="handleClick(index)"-->
<!--          class="nav-button"-->
<!--      >-->
<!--        {{ button.label }}-->
<!--      </button>-->
<!--    </nav>-->

<!--    <div class="store-list">-->
<!--              <div v-if="filteredStores.length === 0">没有找到匹配的商家</div>-->
<!--      <div v-for="(store, index) in stores" :key="index" class="store-item">-->
<!--        <img :src="store.image" alt="店铺图片" class="store-image">-->
<!--        <div class="store-info">-->
<!--          <h2 class="store-name">{{ store.name }}</h2>-->
<!--          <div class="store-details">-->
<!--            <span class="store-rating">{{ store.rating }}分</span>-->
<!--            <span class="monthly-sales">月售{{ store.sales }}+</span>-->
<!--            <span class="distance">{{ store.distance }}km</span>-->
<!--            <span class="avgprice">¥{{ store.avgprice }}</span>-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->


<!--<script>-->
<!--// import HeaderBar from '@/components/HeaderBar.vue';-->

<!--export default {-->
<!--  name: 'ElemePage',-->
<!--  // components: {-->
<!--  //   HeaderBar-->
<!--  // },-->
<!--  data() {-->
<!--    return {-->
<!--      buttons: [-->
<!--        {label: '评分↓', isActive: false, order: 'desc', field: 'rating'},-->
<!--        {label: '人气↓', isActive: false, order: 'desc', field: 'sales'},-->
<!--        {label: '距离↓', isActive: false, order: 'desc', field: 'distance'},-->
<!--        {label: '人均价↑', isActive: false, order: 'asc', field: 'avgprice'}-->
<!--      ],-->
<!--      stores: [],-->
<!--      userPhone: '',-->
<!--      searchQuery: '',-->
<!--      filteredStores: []-->
<!--    };-->
<!--  },-->
<!--  methods: {-->
<!--    navigateToMenu(businessid) {-->
<!--      console.log('Navigating to MenuSelection with businessid:', businessid);-->
<!--      // 添加条件以确保 businessid 是有效的-->
<!--      if (businessid) {-->
<!--        this.$router.push({name: 'MenuSelection', query: {businessid}});-->
<!--      } else {-->
<!--        console.error('Invalid businessid:', businessid);-->
<!--      }-->
<!--    },-->
<!--    handleClick(index) {-->
<!--      this.buttons.forEach((button, i) => {-->
<!--        if (i === index) {-->
<!--          // 切换升降序-->
<!--          if (button.isActive === true) {-->
<!--            button.order = button.order === 'asc' ? 'desc' : 'asc';-->
<!--            button.label = `${button.label.slice(0, -1)}${button.order === 'asc' ? '↑' : '↓'}`;-->
<!--          }-->
<!--          button.isActive = true;-->

<!--          // 根据按钮的 field 和 order 对 stores 进行排序-->
<!--          this.stores.sort((a, b) => {-->
<!--            if (button.order === 'asc') {-->
<!--              return a[button.field] - b[button.field];-->
<!--            } else {-->
<!--              return b[button.field] - a[button.field];-->
<!--            }-->
<!--          });-->

<!--        } else {-->
<!--          button.isActive = false;-->
<!--        }-->
<!--      });-->
<!--    },-->
<!--  },-->
<!--  fetchStores(sortField = 'rating', sortOrder = 'desc') {-->
<!--    fetch(`http://localhost:8081/business/all?sortField=${sortField}&sortOrder=${sortOrder}`)-->
<!--        .then(response => response.json())-->
<!--        .then(data => {-->
<!--          console.log(data);-->
<!--          this.stores = data.data;-->
<!--          this.filteredStores = this.stores;-->
<!--        })-->
<!--        .catch(error => {-->
<!--          console.error('Error fetching stores:', error);-->
<!--        });-->
<!--  },-->

<!--  onLogoClick() {-->
<!--    console.log('Logo clicked!');-->
<!--  },-->
<!--  onSearch(query) {-->
<!--    console.log('Search query:', query);-->
<!--  },-->
<!--  onViewOrders() {-->
<!--    console.log('View orders clicked!');-->
<!--  },-->
<!--  onLogout() {-->
<!--    console.log('Logout clicked!');-->
<!--  },-->

<!--  searchStores() {-->
<!--    if (this.searchQuery.trim() === '') {-->
<!--      this.filteredStores = this.stores;-->
<!--    } else {-->
<!--      const query = this.searchQuery.toLowerCase();-->
<!--      this.filteredStores = this.stores.filter(store =>-->
<!--          store.name.toLowerCase().includes(query)-->
<!--      );-->
<!--    }-->
<!--  },-->


<!--  logout() {-->
<!--    localStorage.removeItem('userPhone');-->
<!--    this.$router.push({name: 'LogIn'});-->
<!--  },-->
<!--  created() {-->
<!--    this.fetchStores();-->
<!--    this.userPhone = localStorage.getItem('userPhone');-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.eleme-page {-->
<!--  padding: 16px;-->
<!--  background-color: white;-->

<!--  text-align: center;-->

<!--  margin-bottom: 16px;-->
<!--  border-radius: 8px;-->
<!--}-->


<!--.navigation {-->
<!--  display: flex;-->
<!--  justify-content: center;-->
<!--  margin-bottom: 16px;-->
<!--}-->

<!--.nav-button {-->
<!--  margin: 0 8px;-->
<!--  padding: 8px 16px;-->
<!--  background-color: #f0f0f0;-->
<!--  border: none;-->
<!--  border-radius: 4px;-->
<!--  cursor: pointer;-->
<!--  box-shadow: 0 1px 3px rgba(0,0,0,0.1);-->
<!--  transition: background-color 0.3s ease;-->
<!--  color: black;-->
<!--}-->

<!--/* 鼠标悬停时的颜色渐变效果 */-->
<!--.nav-button:hover {-->
<!--  background-color: #007bff; /* 设置悬停时的背景颜色，可以根据需要修改 */-->
<!--  color: white;-->
<!--}-->

<!--.nav-button.active {-->

<!--  background-color: #007bff; /* 保持蓝色 */-->
<!--  color: white;-->

<!--}-->

<!--.store-list {-->
<!--  margin: 0 20%;-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  gap: 16px;-->
<!--}-->

<!--.store-item {-->
<!--  display: flex;-->
<!--  align-items: center;-->
<!--  background-color: white;-->
<!--  padding: 16px;-->
<!--  border-radius: 8px;-->
<!--  box-shadow: 0 1px 3px rgba(0,0,0,0.1);-->
<!--  border: 1px solid;-->
<!--}-->

<!--.store-image {-->
<!--  width: 80px;-->
<!--  height: 80px;-->
<!--  border-radius: 4px;-->
<!--  margin-right: 16px;-->
<!--}-->

<!--.store-info {-->
<!--  flex-grow: 1;-->
<!--  text-align: left;-->
<!--}-->

<!--.store-name {-->
<!--  font-size: 18px;-->
<!--  margin-bottom: 8px;-->
<!--}-->

<!--.store-details {-->
<!--  display: flex;-->
<!--  gap: 16px;-->
<!--}-->

<!--.store-rating,-->
<!--.monthly-sales,-->
<!--.distance,-->
<!--.avg_price{-->
<!--  font-size: 14px;-->
<!--}-->

<!--/* 原来的 header 样式已经被移动到 HeaderBar 组件中 */-->
<!--/* 其他样式保持不变 */-->
<!--</style>-->




<template>
<!--  <img src="../assets/shops/shop1.png" alt="">-->
  <div class="eleme-page">
    <header class="header">
      <button class="logo-btn" @click="logoclick">
        <img src="../assets/eleme-logo.png" alt="Eleme Logo" class="logo"/>
        <h1>ELEME</h1>
      </button>
      <div class="search-bar" v-if="showSearch">
        <input type="text" placeholder="搜索" v-model="searchQuery" @keyup.enter="search">
        <button @click="searchStores">搜索</button>
      </div>
      <div class="user-info">
        <span>{{ userPhone }}</span>
        <button @click="viewOrders">我的订单</button>
        <button @click="logout">退出</button>
      </div>
    </header>

    <nav class="navigation">
      <button
          v-for="(button, index) in buttons"
          :key="index"
          :class="{ active: button.isActive }"
          @click="handleClick(index)"
          class="nav-button"
      >
        {{ button.label }}
      </button>
    </nav>

    <div class="store-list">
      <div v-if="filteredStores.length === 0">没有找到匹配的商家</div>
      <div v-for="(store, index) in filteredStores" :key="index" class="store-item" @click="navigateToMenu(store.businessid)">
        <img :src="store.imageurl" alt="店铺图片" class="store-image">
        <div class="store-info">
          <h2 class="store-name">{{ store.name }}</h2>
          <div class="store-details">
            <span class="store-rating">{{ store.rating }}分</span>
            <span class="monthly-sales">月售{{ store.sales }}+</span>
            <span class="distance">{{ store.distance }}km</span>
            <span class="avg-price">均价{{ store.avgprice }}元</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ElemePage',
  props: {
    showSearch: {
      type: Boolean,
      default: true  // 默认显示搜索框
    }
  },
  data() {
    return {
      buttons: [
        { label: '评分↓', isActive: false, order: 'desc', field: 'rating' },
        { label: '人气↓', isActive: false, order: 'desc', field: 'sales' },
        { label: '距离↓', isActive: false, order: 'desc', field: 'distance' },
        { label: '人均价↑', isActive: false, order: 'asc', field: 'avgprice' }
      ],
      stores: [],
      userPhone: '',
      searchQuery: '',
      filteredStores: []
    };
  },
  methods: {
    logoclick() {
      this.$router.push({name: 'ShopSelection'});
    },
    viewOrders() {
      this.$router.push({name: 'MyOrder'});
    },


    navigateToMenu(businessid) {
      console.log('Navigating to MenuSelection with businessid:', businessid);
      // 添加条件以确保 businessid 是有效的
      if (businessid) {
        this.$router.push({ name: 'MenuSelection', query: { businessid } });
      } else {
        console.error('Invalid businessid:', businessid);
      }
    },


    handleClick(index) {
      this.buttons.forEach((button, i) => {
        if (i === index) {
          button.isActive = true;
          button.order = button.order === 'asc' ? 'desc' : 'asc';
          button.label = `${button.label.slice(0, -1)}${button.order === 'asc' ? '↑' : '↓'}`;
          this.fetchStores(button.field, button.order);
        } else {
          button.isActive = false;
        }
      });
    },
    fetchStores(sortField = 'rating', sortOrder = 'desc') {
      fetch(`http://localhost:8081/business/all?sortField=${sortField}&sortOrder=${sortOrder}`)
          .then(response => response.json())
          .then(data => {
            console.log(data);
            this.stores = data.data;
            this.filteredStores = this.stores;
          })
          .catch(error => {
            console.error('Error fetching stores:', error);
          });
    },
    searchStores() {
      if (this.searchQuery.trim() === '') {
        this.filteredStores = this.stores;
      } else {
        const query = this.searchQuery.toLowerCase();
        this.filteredStores = this.stores.filter(store =>
            store.name.toLowerCase().includes(query)
        );
      }
    },
    logout() {
      localStorage.removeItem('userPhone');
      this.$router.push({ name: 'LogIn' });
    }
  },
  created() {
    this.fetchStores();
    this.userPhone = localStorage.getItem('userPhone');
  }
};
</script>

<style scoped>

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

.eleme-page {
  padding: 16px;
  background-color: white;

  text-align: center;

  margin-bottom: 16px;
  border-radius: 8px;
}


.navigation {
  display: flex;
  justify-content: center;
  margin-bottom: 16px;
}

.nav-button {
  margin: 0 8px;
  padding: 8px 16px;
  background-color: #f0f0f0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  box-shadow: 0 1px 3px rgba(0,0,0,0.1);
  transition: background-color 0.3s ease;
  color: black;
}

/* 鼠标悬停时的颜色渐变效果 */
.nav-button:hover {
  background-color: #007bff; /* 设置悬停时的背景颜色，可以根据需要修改 */
  color: white;
}

.nav-button.active {

  background-color: #007bff; /* 保持蓝色 */
  color: white;

}

.store-list {
  margin: 0 20%;
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.store-item {
  display: flex;
  align-items: center;
  background-color: white;
  padding: 16px;
  border-radius: 8px;
  box-shadow: 0 1px 3px rgba(0,0,0,0.1);
  border: 1px solid;
}

.store-image {
  width: 80px;
  height: 80px;
  border-radius: 4px;
  margin-right: 16px;
}

.store-info {
  flex-grow: 1;
  text-align: left;
}

.store-name {
  font-size: 18px;
  margin-bottom: 8px;
}

.store-details {
  display: flex;
  gap: 16px;
}

.store-rating,
.monthly-sales,
.distance,
.avg_price{
  font-size: 14px;
}

/* 原来的 header 样式已经被移动到 HeaderBar 组件中 */
/* 其他样式保持不变 */
</style>


