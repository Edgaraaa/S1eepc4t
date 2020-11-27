<template>
    <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">
    <el-form-item label="队伍token">
        <el-input v-model="formLabelAlign.token"></el-input>
    </el-form-item>
    <el-form-item label="题目id">
        <el-input v-model="formLabelAlign.id"></el-input>
    </el-form-item>
    <el-form-item label="flag">
        <el-input v-model="formLabelAlign.flag"></el-input>
    </el-form-item>
    
    <div class="div">提供提交flag接口：http://127.0.0.1:8080/api/challenge/submitFlag POST flag=xxxxx</div>
    <br><el-button type="primary" @click="onSubmit">提交flag</el-button>
    </el-form>
</template>

<script>
import axios from 'axios';
  export default {
    data() {
      return {
        labelPosition: 'right',
        formLabelAlign: {
          token: '',
          flag: '',
          id:''
        }
      };
    },
    methods:{
        onSubmit() {
            var that=this;
            let date = new FormData();
            let token = localStorage.getItem('ms_token');
            date.append('flag',that.formLabelAlign.flag);
            date.append('cid',that.formLabelAlign.id);
            date.append('tid',that.formLabelAlign.token)
            axios.post('http://127.0.0.1:8080/api/challenge/submitFlag?token='+token,date).then(function(response){
                if(response.data=="回答正确") {
                    that.$message.success(response.data);
                }else{
                    that.$message.error(response.data);
                }
            });
        },
    }
  }
</script>

<style>
.div{
    font-size: 5%;
    color: rgba(77, 77, 77, 0.534);
}
</style>