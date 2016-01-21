var httptools = require('../util-http/http_requests');

describe('util-fs', function() {
    it("GET", function() {
        var data = {
            begin: new Date(2015, 1, 1).getTime(),
            end: new Date().getTime()
        };

        var options = {
            hostname: '192.168.112.152',
            port: 8080,
            path: '/cgpboss-portal-web/api/alarm/list',
            method: 'GET',
            headers: {
                'Cookie': 'JSESSIONID=9C594381D264EB8C5693E77A847CBA97',
                'Content-Type': 'application/json; charset=UTF-8'
            }
        };

        httptools.get(data, options);
    })

    it("POST", function() {
        var body = {
            "attackId": "d4b88ea0b07e487f8b59c4fb4edbf813",
            "trafficRate": 693.77696
        };

        var options = {
            hostname: '192.168.112.152',
            port: 8080,
            path: '/cgpboss-admin-web/api/attack/1.1.1.1/notice',
            method: 'POST',
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        };

        httptools.post(options, body);
    })
})