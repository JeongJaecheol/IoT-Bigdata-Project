const request = require('request');

const searchNewAddress = (searchWord) => {
    var uri = 'http://openapi.epost.go.kr/postal/retrieveNewAdressAreaCdService/retrieveNewAdressAreaCdService/getNewAddressListAreaCd';
    /* Service Key*/
    var queryString = '?ServiceKey=' + 'swGnUeGbwJTEP%2FoOuEZsMstoBza7CSMZhJ%2FQGdasAbhNX5oUrxUn8sSJ3YjY3H0Og39RlBLPXtKWmxqRKjHAwQ%3D%3D';

    /* dong : 동(읍/면)명 road :도로명[default] post : 우편번호 */
    queryString += '&searchSe=road';

    /* 검색어 */
    queryString += '&srchwrd=' + encodeURIComponent(searchWord); 

    /* 페이지당 출력될 개수를 지정 */
    queryString += '&currentPerPage=10';

    /* 출력될 페이지 번호 */
    queryString += '&currentPage=1';

    request({
        uri: uri + queryString,
    }, function (error, response, body) {
        console.log('=> Status', response.statusCode);
        console.log('=> Headers', JSON.stringify(response.headers));
        console.log('=> Reponse received', body);
    });  
};

searchNewAddress('금화로82번길 17');

/*
module.exports = {
    searchNewAddress
};
*/