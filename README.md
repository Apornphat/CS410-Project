# CS410-Project

# CS 410 Final Project — Simple Calculator

**Java Implementation: Static Typing & Imperative Control Flow**

จัดทำโดย: กัญญาณัฐ, จตุพร, อาภรณ์ภัทร์, กษิรา

---

## วิธีรันโปรแกรม

### ขั้นที่ 1 — เปิด Codespace
1. คลิกปุ่ม **Code** (สีเขียว) ด้านบนขวาของ repo
2. เลือกแถบ **Codespaces**
3. คลิก Codespace ที่มีอยู่ (ชื่อ **effective fishstick**)
4. รอให้ระบบโหลดจนเสร็จ

### ขั้นที่ 2 — รันโปรแกรม
เปิด **Terminal** แล้วพิมพ์:
```bash
javac Main.java && java Main
```

### ขั้นที่ 3 — เปิดหน้าจอ Desktop
1. คลิกแถบ **PORTS** ด้านล่าง
2. จะเห็น Port **6080** (websockify)
3. คลิก **Open in Browser** (ไอคอนลูกโลก)
4. คลิกปุ่ม **Connect** (ไม่ต้องใส่รหัสผ่าน)

### ขั้นที่ 4 — ใช้งานเครื่องคิดเลข
หน้าต่าง **Simple Calculator** จะเด้งขึ้นมาในหน้าจอ Desktop
1. กรอก **First Number**
2. เลือก **Operator** (+, -, ×, ÷)
3. กรอก **Second Number**
4. คลิกปุ่ม **Calculate**
5. ดูผลลัพธ์ที่ช่อง **Result**

---

## โครงสร้างโปรเจกต์

## โครงสร้างโปรเจกต์                                                                                
CS410-Project/                                                                                    
├── Main.java          # โค้ดหลัก (Simple Calculator GUI)                                          
├── .devcontainer/                                                                                
│   ├── devcontainer.json  # ตั้งค่า Java + Desktop                                                  
│   └── Dockerfile         # แก้ไข Yarn repo issue                                                 
└── README.md

---

## คุณสมบัติของภาษา Java ที่ใช้

- **Static Typing** — ประกาศชนิดตัวแปรชัดเจน เช่น `double`, `char`
- **Imperative Control Flow** — ใช้ `switch-case`, `try-catch-finally`
- **OOP** — ใช้ `class`, `extends JFrame`
- **GUI** — ใช้ Java Swing (`JFrame`, `JTextField`, `JButton`, `JComboBox`)
