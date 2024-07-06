<template>
  <div class="pay-complete">
    <h2>支付成功！</h2>
    <div class="icon">✔</div>
    <div class="options">
      <p>您可以选择：</p>
      <button @click="goHome">返回主页</button>
      <button @click="viewOrders">查看我的订单</button>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    goHome() {
      // 转到主页
      this.$router.push('/shop-selection');
      console.log('返回主页');
    },
    viewOrders() {
        // 转到路由/my-order
        this.$router.push('/my-order');
      console.log('查看我的订单');
    },
  },
};
</script>

<style>
.pay-complete {
    border: 1px solid #007bff;
    width: 300px;
    height: 400px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin: 0 auto;
    margin-top: 100px;
    padding: 20px;
    border-radius: 10px;
}
.icon {
  font-size: 50px;
  margin: 20px 0;
}
.options {
  margin-top: 20px;
}
button {
  background-color: #007bff;
  color: white;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
  margin: 5px;
}
button:hover {
  background-color: #0056b3;
}
</style>
