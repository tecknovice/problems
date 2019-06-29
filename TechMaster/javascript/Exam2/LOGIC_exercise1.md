# Số chính phương
**Số chính phương hay còn gọi là số hình vuông là số tự nhiên có căn bậc 2 là một số tự nhiên, hay nói cách khác, số chính phương là bình phương (lũy thừa bậc 2) của một số tự nhiên. Vài ví dụ về số chính phương là  ```1, 4, 9, 16```**
- Tạo  file ```LOGIC_exercise1.html``` với nội dung sau
```javascript
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Số chính phương</title>
</head>

<body>
    <h1>Số chính phương</h1>
    <script>
        function checkSquareNumber(value) {
        }
        function main(){
           for (let i = 0; i < 1000; i++) {
               if(checkSquareNumber(i))
                document.write(i, '<br/>')
            } 
        }
    </script>
</body>

</html>
```
- Viết thêm vào hàm ```checkSquareNumber``` để kiểm tra 1 số có phải là số chính phương hay không
