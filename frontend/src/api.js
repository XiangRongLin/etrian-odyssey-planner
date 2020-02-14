import axios from "axios";

axios.defaults.baseURL = 'http://localhost:8080/api';

const ApiService = {

    get(url) {
        return axios.get(url)
    },

    post(url, data) {
        return axios.post(url, data, {
            headers: {
                'Content-Type': 'application/json'
            }
        })
    }
};

export default ApiService;

export const PartyService = {
    get() {
        return ApiService.get('party')
    },

    create(data) {
        return ApiService.post('party', data)
    },

    getMembers(partyId) {
        return ApiService.get(`party/${partyId}/member`)
    }
};

export const CharacterService = {
    get(id) {
        return ApiService.get(`character/${id}`)
    }
};