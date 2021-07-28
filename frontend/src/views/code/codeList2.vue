<template>
<div>
  <layout />
  <div class="divLeft">
    <input
      type="text"
      class="searchInput"
      v-model="form.codeNm"
      placeholder="코드명"
      style="display:table-cell;width:90%"
    />
    <input class="searchBtn" type="button" @click="doList" value="조회" />
  </div>
  <div class="mt10" style="height:300px">
    <div style="text-align:left">
      <span>대표코드</span>
    </div>
    <table style="width:100%" class="mt10" @row-click="doDetailList">
      <colgroup>
        <col width="10%" />
        <col width="20%" />
        <col width="20%" />
        <col width="10%" />
        <col width="10%" />
        <col width="10%" />
        <col width="10%" />
        <col width="10%" />
      </colgroup>
      <thead>
        <td scope="col">코드</td>
        <td scope="col">코드명</td>
        <td scope="col">코드영문명</td>
        <td scope="col">코드순서</td>
        <td scope="col">사용여부</td>
        <td scope="col">연결코드1</td>
        <td scope="col">연결코드2</td>
        <td scope="col">연결코드3</td>
      </thead>
      <tbody>
        <tr v-for="item in codeInfoList" :key="item.commCdId">
          <td>{{ item.commCdId }}</td>
          <td>{{ item.commCdNm }}</td>
          <td>{{ item.commCdEng }}</td>
          <td>{{ item.cdSort }}</td>
          <td>{{ item.cdUseYn }}</td>
          <td>{{ item.conn1Cd }}</td>
          <td>{{ item.conn2Cd }}</td>
          <td>{{ item.conn3Cd }}</td>
        </tr>
      </tbody>
    </table>
  </div>
  <div class="mt10">
    <div style="text-align:left">
      <span>상세코드</span>
    </div>
    <table style="width:100%" class="mt10">
      <colgroup>
        <col width="10%" />
        <col width="5%" />
        <col width="20%" />
        <col width="15%" />
        <col width="10%" />
        <col width="10%" />
        <col width="10%" />
        <col width="10%" />
        <col width="10%" />
      </colgroup>
      <thead>
        <td scope="col">대표코드</td>
        <td scope="col">코드</td>
        <td scope="col">코드명</td>
        <td scope="col">코드영문명</td>
        <td scope="col">코드순서</td>
        <td scope="col">사용여부</td>
        <td scope="col">연결코드1</td>
        <td scope="col">연결코드2</td>
        <td scope="col">연결코드3</td>
      </thead>
      <tbody>
        <tr v-for="item in codeList" :key="item.cdId">
          <td>{{ item.commCdId }}</td>
          <td>{{ item.cdId }}</td>
          <td>{{ item.cdNm }}</td>
          <td>{{ item.cdEng }}</td>
          <td>{{ item.cdSort }}</td>
          <td>{{ item.cdUseYn }}</td>
          <td>{{ item.conn1Cd }}</td>
          <td>{{ item.conn2Cd }}</td>
          <td>{{ item.conn3Cd }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</div>
</template>

<script>
import layout from '@/views/layout/Layout'
import { reqPost } from '@/api/tran'

export default {
  name: 'CodeList',
  components: { layout },
  data () {
    return {
      form: {
        codeNm: ''
      },
      codeInfoList: [],
      codeList: {}
    }
  },
  methods: {
    doList () {
      reqPost('/code/selectCodeInfo', this.form).then(response => {
        this.codeInfoList = response.data.list
      })
    },
    doDetailList (row) {
      // var detailObj = {
      //   codeNm: form.codeNm,
      //   commCdId: row.commCdId
      // }
      // reqPost('/code/selectCodeList', this.form).then(response => {
      //   this.codeList = response.data.list
      // })
    }
  }
}
</script>
