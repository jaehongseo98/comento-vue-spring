<template>
<div>
  <layout />
  <div class="divLeft" style="display:flex">
    <input
      type="text"
      class="searchInput"
      placeholder="코드명"
      style="display:table-cell;width:90%"
    />
    <input
      class="searchBtn"
      type="button"
      @click="doList"
      value="조회"
      style="margin-top: 10px; margin-left: 5px;"
    />
  </div>
  <div class="mt10" style="text-align:left">
    <span>대표코드</span>
  </div>
  <table style="width:100%" class="mt10">
    <colgroup>
      <col width="10%" />
      <!--  한 열 -->
      <col width="20%" />
      <col width="20%" />
      <col width="10%" />
      <col width="10%" />
      <col width="10%" />
      <col width="10%" />
      <col width="10%" />
    </colgroup>
    <thead>
      <!--테이블 헤더 그룹 그룹핑 대상:행 <->col 과 반대되는 개념-->
      <td scope="col">코드</td>
      <!-- scope=col 헤더셀 세로 적용 -->
      <td scope="col">코드명</td>
      <td scope="col">코드영문명</td>
      <td scope="col">코드순서</td>
      <td scope="col">사용여부</td>
      <td scope="col">연결코드1</td>
      <td scope="col">연결코드2</td>
      <td scope="col">연결코드3</td>
    </thead>
    <tbody>
      <tr
        v-for="item in codeInfoList"
        :key="item.commCdId"
        @click="doDetailList(item)"
      >
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
  <div style="margin-bottom:15%"></div>
  <div class="mt10" style="text-align:left">
    <span>상세코드</span>
  </div>
  <table style="width:100%" class="mt10">
    <colgroup>
      <col width="10%" />
      <!--  한 열 -->
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
      <!--테이블 헤더 그룹 그룹핑 대상:행 <->col 과 반대되는 개념-->
      <td scope="col">대표코드</td>
      <!-- scope=col 헤더셀 세로 적용 -->
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
      detailObj: {
        codeNm: '',
        commCdId: ''
      },
      codeInfoList: [],
      codeList: {}
    }
  },
  methods: {
    doList () {
      reqPost('/api/code/selectCodeInfo', this.form).then(response => {
        this.codeInfoList = response.data.list
        console.log(`${this.codeInfoList}야미`)
      })
    },
    doDetailList (row) {
      this.detailObj.codeNm = this.form.codeNm
      this.detailObj.commCdId = row.commCdId
      reqPost('/api/code/selectCodeList', this.detailObj).then(response => {
        this.codeList = response.data.list
      })
    }
  }
}
</script>
