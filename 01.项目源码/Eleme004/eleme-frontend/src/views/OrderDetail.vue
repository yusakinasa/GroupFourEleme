<!-- src/views/OrderDetails.vue -->
<template>
  <!-- 使用 HeaderBar 组件 -->
  <HeaderBar :username="username" />
  <div class="order-page">
    <section class="order-details">
      <h2>订单详情</h2>
      <div class="main-info">
        <div class="order-summary">
          <h3>订单已完成</h3>
          <p style="text-align: center; font-weight: bold;">感谢信任，期待再次光临</p>
          <div class="contact-info">
            <span>联系商家</span>
            <span class="tel-num"> {{ contactNumber }}</span>
          </div>
        </div>
        <div class="order-items">
          <el-button class="shop-redirect-btn" type="text" @click="redirectToShop">红张飞 · 中国炸鸡（华科校园店）></el-button>
          <div class="order-items-list">
            <div class="order-item" v-for="(item, index) in items" :key="index">
              <div class="item-info">
                <img :src="item.image" alt="商品图片" class="item-image">
              </div>
              <div class="item-details">
                <span class="item-name">{{ item.name }}</span>
                <span class="item-quantity">×{{ item.account }}</span>
              </div>
              <span class="item-price">¥{{ item.price }}</span>
            </div>
          </div>
          <div class="order-summary-total">
            <div class="cost-info total">
              <span class="label">总计：</span>
              <span class="total-price">¥{{ totalPrice }}</span>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="bottom-info">
      <section class="shipping-info">
        <h3>收货人信息</h3>
        <div class="info-line" v-for="(detail, index) in shippingDetails" :key="index">
          <span class="label">{{ detail.label }}: </span>
          <span class="value">{{ detail.value }}</span>
        </div>
        <div class="specific-info">
          <span class="label">手机号码:</span>
          <span class="value">{{masked_userPhoneNumber}}</span>
        </div>
      </section>
      <section class="payment-info">
        <h3>付款信息</h3>
        <div class="info-line" v-for="(detail, index) in paymentDetails" :key="index">
          <span class="label">{{ detail.label }}: </span>
          <span class="value">{{ detail.value }}</span>
        </div>
      </section>
    </section>
  </div>
</template>

<script>
import HeaderBar from '@/components/HeaderBar.vue';

export default {
  name: 'OrderDetails',
  components: {
    HeaderBar
  },
  data() {
    return {
      username: 'user256',
      items: [
        {
          name: '软糯年糕',
          price: 6.70,
          image: 'http://localhost:8081/static/images/food1.png',
          account: 1
        },
        {
          name: '云南爆浆豆腐',
          price: 5.40,
          image: 'http://localhost:8081/static/images/food2.png',
          account: 2
        },
      ],
      shippingDetails: [
        { label: '收货人', value: '屈唯一' },
        { label: '地址', value: '湖北武汉市洪山区关山街道华中科技大学东校区韵苑宿舍16栋' },
      ],
      userPhoneNumber:'15826506260',
      paymentDetails: [
        { label: '付款方式', value: 'wechatpay' },
        // { label: '付款时间', value: '2024-05-16 21:58:26' }
      ],
      contactNumber: '15071125798' // 商家联系号码
    };
  },
  computed: {
    // 查找并掩码处理shippingDetails中的电话号码
    masked_userPhoneNumber() {
        return this.userPhoneNumber.replace(/(\d{3})\d{4}(\d{4})/, '$1****$2');
    },
    totalPrice() {
      return this.items.reduce((total, item) => total + item.price * item.account, 0).toFixed(2);
    }
  },
  methods: {
    redirectToShop() {
      this.$router.push({ name: 'ShopSelection' });
    }

  }
};

</script>

<style scoped>
.order-page {
  font-family: Arial, sans-serif;
  margin: 0 10%;
  padding: 20px;
}

.shop-redirect-btn {
  border: none;
  cursor: pointer;
  margin-bottom: 10px;
  padding: 0;
  font-size: 20px;
  font-weight: bold;
  text-align: left;
}

.main-info {
  display: flex;
}

.order-summary {
  border: 1px solid #ddd;
  padding: 30px;
  margin-right: 10px;
  flex: 2;
}

.order-items {
  border: 1px solid #ddd;
  padding: 30px;
  margin-left: 10px;
  flex: 3;
}
/*
.order-items-list {
  border-bottom: 1px solid #ddd;
  margin-top: 10px;
  padding-bottom: 20px;
}

.order-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 10px;
}

.item-image {
  height: 50px;
  width: 50px;
  margin-right: 10px;
}

.item-name {
  font-size: 16px;
}

.item-details {
  display: flex;
  flex-direction: column;
  flex: 1;
}

.item-quantity {
  margin-top: 10px;
  display: flex;
}

.item-price {
  font-size: 16px;
  text-align: right;
}
*/
/*订单价格部分*/
.order-items-list {
  border-bottom: 1px solid #ddd;
  margin-top: 10px;
  padding-bottom: 20px;
}

.order-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 10px;
}

.item-info {
  width: 70px;
}

.item-image {
  height: 50px;
  width: 50px;
  margin-right: 10px;
}

.item-name {
  font-size: 16px;
}

.item-details {
  display: flex;
  flex-direction: column;
  flex: 8;
}

.item-quantity {
  margin-top: 10px;
  display: flex;
}

.item-price {
  flex: 1;
  padding-right: 20px;
  font-size: 16px;
  text-align: right;
}
/*订单价格部分*/
.order-summary-total {
  margin-top: 20px;
}

.cost-info {
  display: flex;
  justify-content: space-between;
  margin: 5px 0;
}

.cost-info.total .label, .cost-info.total .value {
  font-weight: bold;
}

.total-price {
  color: #f44336;
  padding-right: 20px;
}

.shipping-info {
  margin: 20px;
  padding: 20px;
  flex: 1;
}

.payment-info {
  margin: 20px;
  padding: 20px;
  flex: 1;
}

.bottom-info {
  display: flex;
  border: 1px solid #ddd;
}

.info-line{
  display: flex;
}

.specific-info {
  display: flex;
}

.label {
  flex: 1;
  display: flex;
  font-weight: bold;
  margin-bottom: 10px;
}

.value {
  margin-bottom: 10px;
  flex: 1;
  word-wrap: break-word; /* 强制换行 */
  display: flex;
  text-align: left;
}

h3 {
  font-size: 24px;
  font-weight: bold;
  text-align: center;
  margin: 0 0 50px 0;
}

.tel-num {
  margin-left: 20px;
}

.contact-info {
  text-align: center;
  margin-top: 50px;
}

.order-details{
  margin: 0 0 20px 0;
}
</style>