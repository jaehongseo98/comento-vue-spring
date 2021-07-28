import axios from 'axios'

export function reqPost (url, data) {
  axios.defaults.baseURL = 'http://localhost:8888/api'
  axios.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8'
  axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*'

  return axios.post(url, data)
}
