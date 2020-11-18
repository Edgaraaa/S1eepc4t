<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">DozerCTF 登录</div>
            <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
                <el-form-item prop="username">
                    <el-input v-model="param.username" placeholder="username">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input
                        type="password"
                        placeholder="password"
                        v-model="param.password"
                        @keyup.enter.native="login()"
                    >
                        <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
                    </el-input>
                </el-form-item>
                <div class="login-btn">
                    <el-button type="primary" @click="login()">登录</el-button>
                </div>
                <div>
                    <el-link href="/#/register" target="_blank" class="login-tips">注册账号</el-link>
                    <el-link href="/#/login" target="_blank" class="login-tips">忘记密码</el-link>
                </div>
            </el-form>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data: function() {
        return {
            param: {
                username: 'admin',
                password: '123123',
            },
            rules: {
                username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
                password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
            },
        };
    },
    methods: {
        login() {
            var that = this;
            let date = new FormData();
            date.append("username",this.param.username);
            date.append("password",this.param.password);
            axios.post('http://127.0.0.1:8080/testBoot/getUser',date).then(function(response) {
                console.log(response)
                if (response.data["userName"]!="None") {
                    that.$message.success('登录成功');
                    localStorage.setItem('ms_username', that.param.username);
                    that.$router.push('/');
                } else {
                    that.$message.error('请输入正确账号和密码');
                    console.log('error submit!!');
                }
            });
        },
        submitForm() {
            
            this.$refs.login.validate(valid => {
                valid=this.login(this.username,this.password)
                console.log(username)
                if (valid) {
                    this.$message.success('登录成功');
                    localStorage.setItem('ms_username', this.param.username);
                    this.$router.push('/');
                } else {
                    this.$message.error('请输入账号和密码');
                    console.log('error submit!!');
                    return false;
                }
            });
        },
    },
};
</script>

<style scoped>
.login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url(../../assets/img/loginBack.png);
    background-size: 100%;
}
.ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: rgb(0, 0, 0);
    border-bottom: 1px solid #ddd;
}
.ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
}
.ms-content {
    padding: 30px 30px;
}
.login-btn {
    text-align: center;
}
.login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
}
.login-tips {
    font-size: 12px;
    line-height: 30px;
    color: rgb(0, 0, 0);
    display: inline-block;
}
</style>