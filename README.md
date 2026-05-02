# CS410-Project

# CS 410 Final Project — Simple Calculator

**Java Implementation: Static Typing & Imperative Control Flow**

จัดทำโดย: กัญญาณัฐ, จตุพร, อาภรณ์ภัทร์, กษิรา

## วิธีรันโปรแกรม

### 1. เปิด Codespace
คลิกปุ่ม **Code** → **Codespaces** → เลือก Codespace ที่มีอยู่

### 2. รอให้ระบบโหลดเสร็จ
ระบบจะติดตั้ง Java และ Desktop อัตโนมัติ (ใช้เวลาประมาณ 1-2 นาที)

### 3. เปิดหน้าจอ Desktop
ไปที่แถบ **PORTS** ด้านล่าง → คลิก Port **6080** → คลิก **Connect**
> รหัสผ่าน: `vscode`

### 4. รันโปรแกรม
พิมพ์คำสั่งนี้ใน Terminal:
```bash
javac Main.java && java Main
```

### 5. ใช้งาน
หน้าต่างเครื่องคิดเลขจะเด้งขึ้นมาในหน้าจอ Desktop

---

## โครงสร้างโปรเจกต์                                                                                
CS410-Project/                                                                                    
├── Main.java          # โค้ดหลัก (Simple Calculator GUI)                                          
├── .devcontainer/                                                                                
│   ├── devcontainer.json  # ตั้งค่า Java + Desktop                                                  
│   └── Dockerfile         # แก้ไข Yarn repo issue                                                 
└── README.md

