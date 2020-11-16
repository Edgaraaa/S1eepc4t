<template>
    <el-col :span="6">
        <div class="welcomepage">
            <img src="../../assets/img/welcome.gif" class="welcome" alt /><br>
            <br>
            <br><br>
            <el-link href="/#/login" target="_blank">进入平台</el-link>
        </div>
    </el-col>
</template>

<script>
export default {
    data() {
      return {
      }
    }
  }
</script>

<style>
    body{width: 100%;height: 100%;position: relative;background-color: rgb(0, 0, 0)}
    .welcomepage {
        position: absolute;
        top: 50%;
        left: 50%;
        -webkit-transform: translate(-50%, -50%);
        -moz-transform: translate(-50%, -50%);
        -ms-transform: translate(-50%, -50%);
        -o-transform: translate(-50%, -50%);
        transform: translate(-50%, -50%);
    }
    .welcome {
        width: 100%;
        height: 100%;
        margin: 0 auto;
    }
</style>