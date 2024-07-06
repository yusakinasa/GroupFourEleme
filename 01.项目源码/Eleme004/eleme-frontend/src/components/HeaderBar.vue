<!-- src/components/HeaderBar.vue -->
<template>
  <header class="header">
    <button class="logo-btn" @click="logoclick">
      <img src="../assets/eleme-logo.png" alt="Eleme Logo" class="logo"/>
      <h1>ELEME</h1>
    </button>
    <div class="search-bar" v-if="showSearch">
      <input type="text" placeholder="搜索" v-model="searchQuery" @keyup.enter="search">
      <button @click="search">搜索</button>
    </div>
    <div class="user-info">
      <span>{{ userPhone }}</span>
      <button @click="viewOrders">我的订单</button>
      <button @click="logout">退出</button>
    </div>
  </header>
</template>

<script>
export default {
  name: 'HeaderBar',
  userPhone:'',
  props: {
    showSearch: {
      type: Boolean,
      default: true  // 默认显示搜索框
    }
  },
  data() {
    return {
      searchQuery: ''
    };
  },
  methods: {
    logoclick() {
      this.$router.push({name: 'ShopSelection'});
    },
    logout() {
      this.$router.push({name: 'LogIn'});
    },
    search() {
      this.$router.push({name: 'search'});
    },
    viewOrders() {
      this.$router.push({name: 'MyOrder'});
    }

  },
  created() {
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
</style>
