<template>
    <el-row>
        <div class="menu">
            <el-tabs :tab-position="tabPosition" style="height: 200px;" class="horizontal-center">
                <el-tab-pane label="WEB"></el-tab-pane>
                <el-tab-pane label="RE"></el-tab-pane>
                <el-tab-pane label="PWN"></el-tab-pane>
                <el-tab-pane label="MISC"></el-tab-pane>
                <el-tab-pane label="CRYPTO"></el-tab-pane>
            </el-tabs>
        </div>
        <div class="menu">
            <el-col :span="4" v-for="(o, index) in 3" :key="o" :offset="index > 0 ? 2 : 0">
                <el-card :body-style="{ padding: '0px' }">
                <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
                <div style="padding: 10px;">
                    <span>好吃的汉堡</span>
                    <div class="bottom clearfix">
                    <time class="time">{{ currentDate }}</time>
                    <el-button type="text" class="button">解题</el-button>
                    </div>
                </div>
                </el-card>
                <br>
            </el-col>
        </div>
    </el-row>
</template>

<style>
  .time {
    font-size: 13px;
    color: #999;
  }
  .menu {
      display: inline-block;
  }
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }
  .center {
  display: flex;
  justify-content: center;
  align-items: center;
}

.horizontal-center {
  display: flex;
  justify-content: center;
}

.vertical-center {
  display: flex;
  align-items: center;
}
</style>

<script>
export default {
  data() {
    return {
      currentDate: new Date(),
      tabPosition: 'left',
    };
  }
}
</script>