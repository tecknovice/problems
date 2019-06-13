# Thư viện

Tạo 1 list các sách bạn đã đọc và list các sách bạn muốn đọc
- tạo 1 file HTML tên là ```DOM_exercise3.html``` có nội dung sau
```html

```
- Thêm thẻ script vào cuối trang web để viết code JS
- Tạo 1 mảng các sách có cấu trúc sau(dữ liệu tự tìm)
```json
[
  {title: 'The Design of EveryDay Things',
   author: 'Don Norman',
   url: 'https://upload.wikimedia.org/wikipedia/en/3/33/The_Design_of_Everyday_Things_%28cover_1988%29.jpg',
   alreadyRead: false
  },
  {title: 'The Most Human Human',
  author: 'Brian Christian',
  url: 'https://images-na.ssl-images-amazon.com/images/I/51aKPFuUy1L._SX324_BO1,204,203,200_.jpg',
  alreadyRead: true
  },
  ...
]
```
- Sử dụng vòng lặp duyệt qua các sách. Với mỗi sách tạo ra 1 thẻ ```div``` với tên sách, tên tác giả, ảnh bìa rồi đưa nó vào trang web
- Thay đổi style cho mỗi sách tuỳ thuôc vào việc bạn đã đọc nó hay chưa