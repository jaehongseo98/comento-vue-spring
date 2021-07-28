import axios from 'axios'

function createInstance () {
  return axios.create({
    baseURL: 'http://localhost:8888/api'
  })
}

export const $http = createInstance()
