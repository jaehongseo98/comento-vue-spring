<template>
  <div>
    <layout/>
    <div class="divLeft">
      <el-input type="text" class="searchInput" v-model="form.codeNm" placeholder="코드명" style="width:90%" clearable/><!--  display:table-cell; -->
      <el-button class="searchBtn" type="primary" @click="test1">조회</el-button> <!--v-on:click="test" -->
    </div>
    <div class="mt10" style="height:300px;overflow-y: scroll;overflow-x: auto;">
      <div style="text-align:left">
        <span>대표코드</span>
      </div>
      <el-table style="width:100%" class="mt10">
        <colgroup>
          <el width="10%"/>
          <el width="20%"/>
          <el width="20%"/>
          <el width="10%"/>
          <el width="10%"/>
          <el width="10%"/>
          <el width="10%"/>
          <el width="10%"/>
        </colgroup>
        <thead>
          <td scope="el">코드</td>
          <td scope="el">코드명</td>
          <td scope="el">코드영문명</td>
          <td scope="el">코드순서</td>
          <td scope="el">사용여부</td>
          <td scope="el">연결코드1</td>
          <td scope="el">연결코드2</td>
          <td scope="el">연결코드3</td>
        </thead>
        <tbody>
          <tr v-for="item in codeInfoList" :key="item.commCdId" @click="httptest(item)">
            <td>{{item.commCdId}}</td>
            <td>{{item.commCdNm}}</td>
            <td>{{item.commCdEng}}</td>
            <td>{{item.cdSort}}</td>
            <td>{{item.cdUseYn}}</td>
            <td>{{item.conn1Cd}}</td>
            <td>{{item.conn2Cd}}</td>
            <td>{{item.conn3Cd}}</td>
          </tr>
        </tbody>
      </el-table>
    </div>
    <div class="mt10" style="overflow-y: scroll;overflow-x: auto;">
      <div style="text-align:left">
        <span>상세코드</span>
      </div>
      <table style="width:100%" class="mt10">
        <colgroup>
          <el-col width="10%"/>
          <el-col width="5%"/>
          <el-col width="20%"/>
          <el-col width="15%"/>
          <el-col width="10%"/>
          <el-col width="10%"/>
          <el-col width="10%"/>
          <el-col width="10%"/>
          <el-col width="10%"/>
        </colgroup>
        <thead>
          <td scope="el-col">대표코드</td>
          <td scope="el-col">코드</td>
          <td scope="el-col">코드명</td>
          <td scope="el-col">코드영문명</td>
          <td scope="el-col">코드순서</td>
          <td scope="el-col">사용여부</td>
          <td scope="el-col">연결코드1</td>
          <td scope="el-col">연결코드2</td>
          <td scope="el-col">연결코드3</td>
        </thead>
        <tbody>
          <tr v-for="item in codeList" :key="item.cdId">
            <td>{{item.commCdID}}</td>
            <td>{{item.cdId}}</td>
            <td>{{item.cdNm}}</td>
            <td>{{item.cdEng}}</td>
            <td>{{item.cdSort}}</td>
            <td>{{item.cdUseYn}}</td>
            <td>{{item.conn1Cd}}</td>
            <td>{{item.conn2Cd}}</td>
            <td>{{item.conn3Cd}}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import layout from '@/views/layout/Layout'
import {reqPost} from '@/api/tran'
import { test } from '@/api/code'
import axios from 'axios'

export default {
  name: 'CodeList',
  components: { layout },
  data () {
    return {
      form: {
        codeNm: ''
      },
      detailObj: {
        codeNm: '',
        commCdId: ''
      },
      codeInfoList: [],
      codeList: {}
    }
  },
  methods: {
    async test1 () {
      try {
        const { data } = await test()
        this.codeInfoList = data
      } catch (error) {
        console.log(error)
      }
    },
    test2 () {
      async function asy () {
        try {
          const { data } = await axios.get('http://localhost:8888/api/code/selectCodeInfo')
          console.log(typeof (data))
          console.log(this.codeInfoList)
          data.then(response => {
            this.codeInfoList = response.data.codeList
          })
        } catch (error) {
          console.log(error)
        }
      }
      asy()
    },
    httptest (item) {
      axios.get(`http://localhost:8888//api/code/selectMoreCode?code_id=${item.commCdId}`).then(response => {
        this.codeList = response.data
        console.log(response)
      })
    },
    doList () {
      reqPost('/code/selectCodeInfo', this.form).then(response => {
        console.log('성공')
        this.codeInfoList = response.data.codeList
      })
    },
    doDetailList (row) {
      this.detailObj.codeNm = this.form.codeNm
      this.detailObj.commCdId = row.commCdId
      reqPost('/code/selectCodeList', this.detailObj).then(response => {
        console.log(response.data)
        this.codeList = response.data.list
      })
    }
  }
}
</script>
