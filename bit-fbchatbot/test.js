var parseString = require('xml2js').parseString;

var xml = '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><NewAddressListResponse><cmmMsgHeader><requestMsgId></requestMsgId><responseMsgId></responseMsgId><responseTime>20171122:202432491</responseTime><successYN>Y</successYN><returnCode>00</returnCode><errMsg></errMsg><totalCount>31</totalCount><countPerPage>10</countPerPage><totalPage>4</totalPage><currentPage>1</currentPage></cmmMsgHeader><newAddressListAreaCd><zipNo>17072</zipNo><lnmAdres>경기도 용인시 기흥구 금화로 92 (상갈동, 한솔프라자)</lnmAdres><rnAdres>경기도 용인시 기흥구 상갈동 472-2 한솔프라자</rnAdres></newAddressListAreaCd><newAddressListAreaCd><zipNo>17072</zipNo><lnmAdres>경기도 용인시 기흥구 금화로58번길 7 (상갈동, 금화마을대우현대1단지아파트)</lnmAdres><rnAdres>경기도 용인시 기흥구 상갈동 461 금화마을대우현대1단지아파트</rnAdres></newAddressListAreaCd><newAddressListAreaCd><zipNo>17072</zipNo><lnmAdres>경기도 용인시 기흥구 금화로58번길 8 (상갈동, 금화마을주공그린빌상가동)</lnmAdres><rnAdres>경기도 용인시 기흥구 상갈동 463-1 금화마을주공그린빌상가동</rnAdres></newAddressListAreaCd><newAddressListAreaCd><zipNo>17072</zipNo><lnmAdres>경기도 용인시 기흥구 금화로58번길 10 (상갈동, 금화마을주공4단지아파트)</lnmAdres><rnAdres>경기도 용인시 기흥구 상갈동 463 금화마을주공4단지아파트</rnAdres></newAddressListAreaCd><newAddressListAreaCd><zipNo>17072</zipNo><lnmAdres>경기도 용인시 기흥구 금화로58번길 17 (상갈동, 상갈초등학교)</lnmAdres><rnAdres>경기도 용인시 기흥구 상갈동 462 상갈초등학교</rnAdres></newAddressListAreaCd><newAddressListAreaCd><zipNo>17072</zipNo><lnmAdres>경기도 용인시 기흥구 금화로82번길 7 (상갈동, 상갈중학교)</lnmAdres><rnAdres>경기도 용인시 기흥구 상갈동 460 상갈중학교</rnAdres></newAddressListAreaCd><newAddressListAreaCd><zipNo>17072</zipNo><lnmAdres>경기도 용인시 기흥구 금화로82번길 9 (상갈동, 상갈주공프라자)</lnmAdres><rnAdres>경기도 용인시 기흥구 상갈동 459-3 상갈주공프라자</rnAdres></newAddressListAreaCd><newAddressListAreaCd><zipNo>17072</zipNo><lnmAdres>경기도 용인시 기흥구 금화로82번길 13 (상갈동)</lnmAdres><rnAdres>경기도 용인시 기흥구 상갈동 459-2</rnAdres></newAddressListAreaCd><newAddressListAreaCd><zipNo>17072</zipNo><lnmAdres>경기도 용인시 기흥구 금화로82번길 14 (상갈동, 금화마을대우현대1단지아파트)</lnmAdres><rnAdres>경기도 용인시 기흥구 상갈동 461 금화마을대우현대1단지아파트</rnAdres></newAddressListAreaCd><newAddressListAreaCd><zipNo>17072</zipNo><lnmAdres>경기도 용인시 기흥구 금화로82번길 15 (상갈동, 금화마을주공그린빌5단지아파트)</lnmAdres><rnAdres>경기도 용인시 기흥구 상갈동 454-1 금화마을주공그린빌5단지아파트</rnAdres></newAddressListAreaCd></NewAddressListResponse>'

parseString(xml, (err, result) => {
    var headers = result.NewAddressListResponse.cmmMsgHeader[0];
    var totalCount = headers.totalCount[0];
    var countPerPage = headers.countPerPage[0];
    var currentPage = headers.currentPage[0];

    console.log(totalCount);
    console.log(countPerPage);
    console.log(currentPage);
    console.log('------------------------------');

    var addrList = result.NewAddressListResponse.newAddressListAreaCd;
    for (var addr of addrList) {
        console.log(addr.zipNo[0]);
        console.log(addr.rnAdres[0]);
        console.log(addr.lnmAdres[0]);
        console.log('-------------------------')
    }

});