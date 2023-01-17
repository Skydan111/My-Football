import fetch from 'unfetch';

const checkStatus = responce => {
    if (responce.ok) {
        return responce;
    }
    const error = new Error(responce.statusText);
    error.responce = responce;
    return Promise.reject(error);
}

export const getAllPlayers = () =>
    fetch("api/v1/players")
        .then(checkStatus);

export const getTeamsByRate = () =>
    fetch("api/v1/teams/byRate")
        .then(checkStatus);