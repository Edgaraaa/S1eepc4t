<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="题目名称" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
    </el-form-item>
    <el-form-item label="赛题类型" prop="region">
        <el-select v-model="ruleForm.region" placeholder="请选择活动区域">
        <el-option label="web" value="web"></el-option>
        <el-option label="pwn" value="pwn"></el-option>
        <el-option label="re" value="re"></el-option>
        <el-option label="misc" value="misc"></el-option>
        <el-option label="crypto" value="crypto"></el-option>
        <el-option label="其他" value="another"></el-option>
        </el-select>
    </el-form-item>
    <el-form-item label="题目描述" prop="desc">
        <el-input type="textarea" v-model="ruleForm.desc"></el-input>
    </el-form-item>
    <el-form-item label="题目flag" prop="flag">
        <el-input v-model="ruleForm.flag"></el-input>
    </el-form-item>
    <el-form-item label="赛题类型" prop="mode">
        <el-select v-model="ruleForm.mode" placeholder="请选择题目类型">
        <el-option label="static" value="static"></el-option>
        <el-option label="random" value="random"></el-option>
        </el-select>
    </el-form-item>
    <el-form-item label="分值" prop="score" :rules="[
        {required: true,message: '分数必须设置'},
        {type: 'number',message: '必须设置为数字'}
    ]">
        <el-input v-model.number="ruleForm.score" autocomplete="off" ></el-input>
    </el-form-item>
    <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
    </el-form>
</template>

<script>
import axios from 'axios';
  export default {
    data() {
      return {
        ruleForm: {
          name: '',
          region: '',
          desc: '',
          score:123,
          flag:'',
          mode:'',
        },
        rules: {
          name: [
            { required: true, message: '请输入题目名称', trigger: 'blur' },
          ],
          region: [
            { required: true, message: '请选择赛题类型', trigger: 'change' }
          ],
          desc: [
            { required: true, message: '请填写题目描述', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        var that = this;
        let date = new FormData();
        let token=localStorage.getItem('ms_token')
        date.append("titles",that.ruleForm.name);
        date.append("describution",that.ruleForm.desc);
        date.append("flag",that.ruleForm.flag);
        date.append("mode",that.ruleForm.mode)
        date.append("score",that.ruleForm.score)
        date.append("challengeType",that.ruleForm.region);
        axios.post('http://127.0.0.1:8080/api/challenge/addChallenge?token='+token,date).then(function(response){
          console.log(response);
          if(response.data['status']==1) {
            that.$message.success("题目添加成功");
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>