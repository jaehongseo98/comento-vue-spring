<template>
  <div>
    <layout />
    <el-radio-group v-model="ui" class="mt20">
      <el-radio-button label="html">html</el-radio-button>
      <el-radio-button label="element">element-ui</el-radio-button>
    </el-radio-group>
    <div v-if="ui == 'html'">
      <div class="divLeft">
        <input
          type="text"
          class="searchInput"
          v-model="form.name"
          placeholder="제목"
          style="display:table-cell;width:90%"
        />
        <input class="searchBtn" type="button" @click="doList" value="조회" />
      </div>
      <div class="mt10" style="text-align:left">
        <span>공지사항</span>
        <input
          type="button"
          style="float: right; padding: 3px 0"
          value="등록"
        />
      </div>
      <table style="width:100%" class="mt10">
        <colgroup>
          <col width="10%" />
          <col width="60%" />
          <col width="10%" />
          <col width="20%" />
        </colgroup>
        <thead>
          <td scope="col">순번</td>
          <td scope="col">제목</td>
          <td scope="col">조회수</td>
          <td scope="col">작성일자</td>
        </thead>
        <tbody>
          <tr v-for="item in noticeList" :key="item.seqNo">
            <td>{{ item.seqNo }}</td>
            <td>{{ item.subject }}</td>
            <td>{{ item.viewCnt }}</td>
            <td>{{ item.regDttm }}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-if="ui == 'element'" class="mt10">
      <div class="divLeft">
        <el-input
          v-model="form.name"
          placeholder="제목"
          style="width:90%"
        ></el-input>
        <el-button @click="doList" type="primary">조회</el-button>
      </div>
      <el-card class="box-card mt10">
        <div slot="header" class="clearfix" style="text-align:left">
          <span>공지사항</span>
          <el-button style="float: right; padding: 3px 0" type="text"
            >등록</el-button
          >
        </div>
        <el-row type="flex">
          <el-table
            :data="noticeList"
            border
            highlight-current-row
            @row-click="rowSel"
            height="500"
          >
            <el-table-column align="center" label="순번" width="80">
              <template slot-scope="scope">
                {{ scope.row.seqNo }}
              </template>
            </el-table-column>
            <el-table-column label="제목" align="left" width="700">
              <template slot-scope="scope">
                {{ scope.row.subject }}
              </template>
            </el-table-column>
            <el-table-column label="조회수" align="center" width="150">
              <template slot-scope="scope">
                {{ scope.row.viewCnt }}
              </template>
            </el-table-column>
            <el-table-column label="작성일자" align="center" width="148">
              <template slot-scope="scope">
                {{ scope.row.regDttm }}
              </template>
            </el-table-column>
          </el-table>
          <el-form :data="noticeForm" style="width: 68%;margin-left:20px;">
            <el-form-item label="제목">
              <el-input v-model="noticeForm.subject"></el-input>
            </el-form-item>
            <el-form-item label="내용">
              <el-input
                type="textarea"
                :rows="17"
                v-model="noticeForm.ctnt"
              ></el-input>
            </el-form-item>
          </el-form>
        </el-row>
      </el-card>
    </div>
  </div>
</template>

<script>
import layout from '@/views/layout/Layout'
import { reqPost } from '@/api/tran'

export default {
  name: 'Notice',
  components: { layout },
  data () {
    return {
      form: {
        subject: '',
        statCd: ''
      },
      noticeList: [],
      noticeForm: {},
      ui: 'html'
    }
  },
  methods: {
    doList () {
      reqPost('/notice/selectNotice', this.form).then(response => {
        this.noticeList = response.data.list
      })
    },
    rowSel (a, b, c) {
      this.noticeForm = a
    }
  }
}
</script>
