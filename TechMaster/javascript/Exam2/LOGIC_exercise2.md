# Format số điện thoại
Tạo file LOGIC_exercise2.html với nội dung sau
```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Format SĐT</title>
</head>

<body>
    <h1>Format SĐT</h1>
    <script>
        let data = [
            '0945405667',
            '0399563926',
            '0362455817',
            '0862283944',
            '0329861893',
            '0328542436',
            '0335798445',
            '0862729041',
            '0862747205',
            '0332018483'
        ]

        function formatPhoneNumber(phone){
            return phone
        }
       
        function main() {
            data.forEach(phone => {
                document.writeln(`${phone} => ${formatPhoneNumber(phone)} <br/>`)
            });
        }
        main()
    </script>
</body>

</html>
```
- Thêm nội dung vào hàm ```formatPhoneNumber``` để format số điện thoại theo định dạng ```xxx xxx xxxx```
    - ví dụ với số điện thoại ```0945405667```  thì sẽ trả về chuỗi ```094 540 5667``` 
