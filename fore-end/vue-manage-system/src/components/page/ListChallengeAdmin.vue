<template>
  <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      fixed
      prop="cid"
      label="比赛题号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="title"
      label="赛题名称"
      width="150">
    </el-table-column>
    <el-table-column
      prop="describution"
      label="描述"
      width="150">
    </el-table-column>
    <el-table-column
      prop="flag"
      label="flag"
      width="150">
    </el-table-column>
    <el-table-column
      prop="challengeType"
      label="赛题类型"
      width="150">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
        <el-button type="text" size="small">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
    import axios from 'axios';
  export default {
    created(){
        var that = this;
        axios.get('http://127.0.0.1:8080/api/challenge/getAllChallenge').then(function(response) {
            console.log(response.data);
            that.tableData=response.data;
        });
    },
    methods: {
      handleClick(row) {
        console.log(row);
      }
    },

    data() {
      return {
        tableData: []
      }
    }
  }
</script>