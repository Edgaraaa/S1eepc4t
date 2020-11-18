<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">DozerCTF 注册</div>
            <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
                <el-form-item prop="username">
                    <el-input v-model="param.username" placeholder="username">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input v-model="param.password" placeholder="password" type="password">
                        <el-button slot="prepend" icon="el-icon-lock"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="comfirmpassword">
                    <el-input v-model="param.cpassword" placeholder="comfirm password" type="password">
                        <el-button slot="prepend" icon="el-icon-lock"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="email">
                    <el-input v-model="param.email" placeholder="email"  @keyup.enter.native="register()" @blur="OnSubscribe">
                        <el-button slot="prepend" icon="el-icon-message"></el-button>
                    </el-input>
                </el-form-item>
                
                <div class="login-btn">
                    <el-button type="primary" @click="register()">登录</el-button>
                </div>
                <div>
                    <el-link href="/#/login" target="_blank" class="login-tips">登录账号</el-link>
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
                username: null,
                password: null,
                cpassword:null,
                email:null,

            },
            rules: {
                username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
                password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
                cpassword:[{required: true,message: '请二次输入密码',trigger: 'blur'}],
                email:[{required:true,message:'请输入你的邮箱',trigger:'blur'}]
            },
            state:null,
            notes:null,
        };
    },
    methods: {
        OnSubscribe() {
      //邮箱验证的正则表达式
        const reg = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
        let str = this.param.email;
        if (reg.test(str)) {
            // 这里是邮箱验证成功的代码
            return true
        } else {
                this.$message.warning("Email format error");
        }
        },
        register() {
            var that = this;
            if(that.param.username==null || that.param.password==null || that.param.cpassword==null || that.param.email==null ){
                that.$message.error('请将信息填写完整');
                return false
            }
            if(that.param.password!=that.param.cpassword) {
                that.$message.error('两次密码输入不相同');
            }
            let date = new FormData();
            date.append('username',that.param.username)
            date.append('password',that.param.password)
            date.append('cpassword',that.param.cpassword)
            date.append('email',that.param.email)
            axios.post('http://127.0.0.1:8080/testBoot/register',date).then(function(response) {
                console.log(response)
                if(response.data=="注册成功") {
                    that.$message.success("注册成功")
                    that.$router.push('/login')
                }else{
                    that.$message.warning("注册失败")
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