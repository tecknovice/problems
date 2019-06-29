# Giới thiệu

Mỗi trang web cần một phần "Giới thiệu".

## Lưu đoạn mã sau vào file ```DOM_exercise2.html```
``` html
<!DOCTYPE html>
<html>
 <head>
  <meta charset="utf-8"/>
  <title>About Me</title>
</head>
<body>
  <h1>About Me</h1>
  
  <ul>
    <li>Nickname: <span id="nickname"></span>
    <li>Favorites:  <span id="favorites"></span>
    <li>Hometown: <span id="hometown"></span>
   </ul>
  
 </body>
</html>
```
## Sử dụng javascript để thực hiện các việc 
- Thêm một thẻ script vào dưới cùng.
- Thay đổi font chữ của thẻ ```<body>``` trở thành  "Arial, sans-serif".
- Thay thế từng phần (Nickname, Favorites, Hometown) bằng thông tin của riêng bạn.
- Lặp lại qua từng li và thêm class ```listitem```. Sử dụng class vừa thêm để đổi màu của các list item thành màu đỏ (red)
- Tạo một phần tử img mới và đặt thuộc tính src của nó thành avatar của bạn. Đưa phần tử đó vào trang.
