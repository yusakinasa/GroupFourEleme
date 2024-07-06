<template>
  <div class="login-register-wrapper">
    <div class="login-register-container">
      <div class="logo">
        <img src="@/assets/eleme-logo.png" alt="Logo">
        <h1>ELEME</h1>
      </div>
      <div class="tab-buttons">
        <button :class="{ active: isLogin }" @click="toggleForm(true)">登录</button>
        <button :class="{ active: !isLogin }" @click="toggleForm(false)">注册</button>
      </div>
      <div v-if="isLogin" class="form-container">
        <input type="text" placeholder="手机号" v-model="loginPhone">
        <input type="password" placeholder="密码" v-model="loginPassword">
        <button @click="handleLogin">登录</button>
      </div>
      <div v-else class="form-container">
        <input type="text" placeholder="请输入手机号" v-model="registerPhone">
        <input type="password" placeholder="8-16位（大写字母+小写字母+数字）密码" v-model="registerPassword">
        <div class="verification-container">
          <input type="text" placeholder="请输入验证码" v-model="registerCode">
          <valid-code @update:value="updateCode"/>
        </div>
        <button @click="handleRegister">注册</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import ValidCode from '@/components/ValidCode'; // 导入验证码组件

export default {
  name: 'LogIn',
  components: {
    ValidCode // 注册验证码组件
  },
  data() {
    return {
      isLogin: true,
      loginPhone: '',
      loginPassword: '',
      registerPhone: '',
      registerPassword: '',
      registerCode: '',
      generatedCode: ''
    };
  },
  methods: {
    toggleForm(isLogin) {
      this.isLogin = isLogin;
    },
    async handleLogin() {
      try {
        const response = await axios.post('http://localhost:8081/user/login', {
          phone: this.loginPhone,
          password: this.loginPassword
        });
        if (response.data.status === "success") {
          alert('登录成功');
          localStorage.setItem('userPhone', this.loginPhone); // 存储用户手机号
          this.$router.push({ name: 'ShopSelection' }); // 跳转到ShopSelection页面
        } else {
          alert('登录失败: ' + response.data.message);
        }
      } catch (error) {
        alert('登录失败');
      }
    },
    async handleRegister() {
      if (this.registerCode !== this.generatedCode) {
        alert('验证码错误');
        return;
      }
      try {
        const response = await axios.post('http://localhost:8081/user/register', {
          phone: this.registerPhone,
          password: this.registerPassword
        });
        if (response.data.status === "success") {
          alert('注册成功');
        } else {
          alert('注册失败: ' + response.data.message);
        }
      } catch (error) {
        alert('账号已经存在' );
      }
    },
    updateCode(value) {
      this.generatedCode = value;
    }
  }

};
</script>

<style scoped>
.login-register-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f5f5f5;
}

.login-register-container {
  background-color: white;
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  width: 320px;
  text-align: center;
}

.logo {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 20px;
}

.logo img {
  width: 50px;
  height: 50px;
  margin-right: 10px;
}

.logo h1 {
  font-size: 24px;
  margin: 0;
}

.tab-buttons {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}

.tab-buttons button {
  margin: 0 10px;
  padding: 10px 20px;
  border: none;
  background-color: #f0f0f0;
  cursor: pointer;
  border-radius: 5px;
}

.tab-buttons button.active {
  background-color: #007bff;
  color: white;
}

.form-container {
  display: flex;
  flex-direction: column;
}

.form-container input {
  margin-bottom: 10px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: calc(100% - 22px);
}

.form-container button {
  padding: 10px;
  border: none;
  background-color: #007bff;
  color: white;
  cursor: pointer;
  border-radius: 5px;
}

.verification-container {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.verification-container input {
  flex-grow: 1;
}

.get-code {
  padding: 10px;
  background-color: transparent;
  color: #007bff;
  cursor: pointer;
  white-space: nowrap;
}
</style>





