import { $http } from './index.js'

export const test = () => {
  return $http.get('http://localhost:8888/api/code/selectCodeInfo')
}
