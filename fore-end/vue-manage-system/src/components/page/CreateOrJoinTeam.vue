<template>
    <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">
        <div><h4>创建队伍</h4></div>
        <el-form-item label="队名">
            <el-input v-model="formLabelAlign.name"></el-input>
        </el-form-item>
        <el-button type="primary" @click="createTeam">创建团队</el-button>
        <el-row>加入队伍</el-row>
        <el-form-item label="队伍token">
            <el-input v-model="formLabelAlign.token"></el-input>
        </el-form-item>
        <el-button type="primary" @click="joinTeam">加入团队</el-button>
    </el-form>
</template>

<script>
  export default {
    data() {
      return {
        labelPosition: 'right',
        formLabelAlign: {
          name: '',
          token:''
        }
      };
    },
    methods:{
        createTeam() {

        },
        joinTeam() {

        }
    },
    
  }
</script>

<style>

</style>