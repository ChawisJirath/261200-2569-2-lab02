1.give a complete description of AirPurifier class
what should be instance variables?
what should be instance methods?
what should be class variables?
what should be class methods?
1.1 instance variable
model ชนิด String ชื่อรุ่น
roomVolume ชนิด double ปริมาตรห้องที่เครื่องดูแล
on ชนิด boolean เครื่องเปิดอยู่หรือไม่
fanSpeed ชนิด int ระดับพัดลม (0)=>ปิด ,(1-3)=>เปิด
pm2_5 ชนิด double ค่าฝุ่น PM2.5 ปัจจุบันในห้อง
mode ชนิด enum โหมดการทำงานกำหนดให้มีแค่สามโหมดการทำงาน MANUAL,AUTO,SLEEP
1.2 instance methods
Constructor: AirPurifier(String model,double roomVolume,double initialPm2_5)
void turnOn() เปิด
void turnOff() ปิด
void setFanSpeed(int speed) กำหนดความเร็วพัดลม
void setMode(Mode newMode) เลือกโหมดการทำงาน
void updateAirQuality(double newPm2_5) อัปเดตค่า pm2.5
void applyAutoSpeed() กำหนดค่า fanSpeed อัตโนมัติโดยดูจากค่า pm2.5 โดยที่ต้องเป็น AUTO Mode
Mode getModel() อ่านค่า model
boolean isOn() คืนค่าปิด(false)หรือเปิด(true)
int getFanSpeed() อ่านค่า fan speed
double getPm25() อ่านค่า pm2.5
1.3 class variables
int MAX_FAN_SPEED กำหนดให้เท่ากับ3
int totalPurifiers เริ่มที่0
1.4 class methods
int getTotalPurifiers():คืนจำนวนเครื่องที่สร้างทั้งหมด
String airQualityCategory(double pm25):แปลงค่า PM2.5 เป็นชื่อระดับคุณภาพอากาศ


2.for each method proposed above, how do you plan to implement it?
give an overview of the computation
what's needed as inputs?
what's to be returned?
1.AirPurifier(String model, double roomVolume, double initialPm2_5) (Constructor)
   ข้อมูลนำเข้า (Inputs): model (String ชื่อรุ่น), roomVolume (double ปริมาตรห้อง), initialPm2_5 (double ค่าฝุ่น PM2.5 เริ่มต้น)

ภาพรวมการทำงาน: กำหนดค่าเริ่มต้นให้กับตัวแปรของอ็อบเจกต์จากข้อมูลที่รับเข้ามา ตั้งสถานะเครื่องเป็นปิด (on = false), ความเร็วพัดลมเป็น 0, โหมดเป็น Mode.MANUAL และบวกเพิ่มตัวนับ totalPurifiers ขึ้น 1

ค่าที่ส่งกลับ (Return): ไม่มี (สร้างอินสแตนซ์ใหม่ของคลาส AirPurifier)

2.turnOn()
   ข้อมูลนำเข้า (Inputs): ไม่มี

ภาพรวมการทำงาน: ตรวจสอบว่าเครื่องเปิดอยู่แล้วหรือไม่ หากเปิดอยู่แล้วจะจบการทำงานทันที หากปิดอยู่จะเปลี่ยน on เป็น true, ตั้ง fanSpeed เป็น 1 และเรียกใช้ applyAutoSpeed() เพื่อปรับความเร็วพัดลมในกรณีที่เครื่องอยู่ในโหมด AUTO

ค่าที่ส่งกลับ (Return): ไม่มี (void)

3.turnOff()
   ข้อมูลนำเข้า (Inputs): ไม่มี

ภาพรวมการทำงาน: ตรวจสอบว่าเครื่องปิดอยู่แล้วหรือไม่ หากปิดอยู่แล้วจะจบการทำงานทันที หากเปิดอยู่จะเปลี่ยน on เป็น false และปรับ fanSpeed กลับเป็น 0

ค่าที่ส่งกลับ (Return): ไม่มี (void)

4.setFanSpeed(int speed)
   ข้อมูลนำเข้า (Inputs): speed (int ระดับความเร็วพัดลมที่ต้องการ)

ภาพรวมการทำงาน: ตรวจสอบว่า speed อยู่ในช่วง 1 ถึง MAX_FAN_SPEED (3) หรือไม่ และตรวจสอบว่าเครื่องเปิดอยู่หรือไม่ หากไม่ผ่านเงื่อนไขจะพิมพ์ข้อความแจ้งเตือนแล้วจบการทำงาน หากผ่านจะอัปเดต fanSpeed ตามค่าที่รับมาและเปลี่ยน mode เป็น Mode.MANUAL

ค่าที่ส่งกลับ (Return): ไม่มี (void)

5.setMode(Mode newMode)
   ข้อมูลนำเข้า (Inputs): newMode (Mode โหมดการทำงานใหม่ ได้แก่ MANUAL, AUTO, หรือ SLEEP)

ภาพรวมการทำงาน: เปลี่ยนค่า mode เป็น newMode จากนั้นตรวจสอบเงื่อนไขเพิ่มเติม: หากเป็น Mode.SLEEP และเครื่องเปิดอยู่จะปรับ fanSpeed เป็น 1, หากเป็น Mode.AUTO จะเรียก applyAutoSpeed(), กรณีอื่นจะจบการทำงานทันที

ค่าที่ส่งกลับ (Return): ไม่มี (void)

6.applyAutoSpeed()
   ข้อมูลนำเข้า (Inputs): ไม่มี (ใช้ค่า on, mode, และ pm2_5 ภายในคลาส)

ภาพรวมการทำงาน: ตรวจสอบว่าเครื่องเปิดอยู่และอยู่ในโหมด AUTO หรือไม่ หากไม่ใช่จะจบการทำงานทันที หากใช่จะเปรียบเทียบค่า pm2_5 เพื่อตั้งระดับพัดลม: น้อยกว่าหรือเท่ากับ 12 ตั้งเป็น 1, น้อยกว่าหรือเท่ากับ 35.4 ตั้งเป็น 2, และมากกว่า 35.4 ตั้งเป็น 3

ค่าที่ส่งกลับ (Return): ไม่มี (void)

7.updateAirQuality(double newPm2_5)
   ข้อมูลนำเข้า (Inputs): newPm2_5 (double ค่าฝุ่น PM2.5 ล่าสุด)

ภาพรวมการทำงาน: ตรวจสอบว่า newPm2_5 น้อยกว่า 0 หรือไม่ หากติดลบจะพิมพ์ข้อความแจ้งเตือนและจบการทำงาน หากถูกต้องจะอัปเดตค่า pm2_5 เป็นค่าใหม่ และหากเครื่องเปิดอยู่ในโหมด AUTO จะเรียก applyAutoSpeed() เพื่อปรับพัดลมตามค่าฝุ่นใหม่ทันที

ค่าที่ส่งกลับ (Return): ไม่มี (void)

8.airQualityCategory(double pm25)
   ข้อมูลนำเข้า (Inputs): pm25 (double ค่าฝุ่น PM2.5 ที่ต้องการประเมิน)

ภาพรวมการทำงาน: เปรียบเทียบค่าฝุ่นที่รับเข้ามากับเกณฑ์มาตรฐาน 6 ช่วง (<= 12, <= 35.4, <= 55.4, <= 150.4, <= 250.4, และมากกว่า 250.4) เพื่อแปลงเป็นข้อความระดับคุณภาพอากาศ

ค่าที่ส่งกลับ (Return): String ระบุระดับคุณภาพอากาศ ได้แก่ "Good", "Moderate", "Unhealthy for Sensitive Groups", "Unhealthy", "Very Unhealthy", หรือ "Hazardous"

9.getMode()
   ข้อมูลนำเข้า (Inputs): ไม่มี

ภาพรวมการทำงาน: ดึงค่าโหมดการทำงานปัจจุบันจากตัวแปร mode

ค่าที่ส่งกลับ (Return): Mode (โหมดปัจจุบันของเครื่อง)

10.isOn()
    ข้อมูลนำเข้า (Inputs): ไม่มี

ภาพรวมการทำงาน: ดึงค่าสถานะการเปิด-ปิดเครื่องจากตัวแปร on

ค่าที่ส่งกลับ (Return): boolean (true หากเปิดอยู่, false หากปิดอยู่)

11.getFanSpeed()
    ข้อมูลนำเข้า (Inputs): ไม่มี

ภาพรวมการทำงาน: ดึงค่าระดับความเร็วพัดลมปัจจุบันจากตัวแปร fanSpeed

ค่าที่ส่งกลับ (Return): int (ระดับความเร็วพัดลม 0 ถึง 3)

12.getPm25()
    ข้อมูลนำเข้า (Inputs): ไม่มี

ภาพรวมการทำงาน: ถ้าเครื่องฟอกอากาศเปิดอยู่จะดึงค่าฝุ่น PM2.5 ปัจจุบันจากตัวแปร pm2_5 ถ้าเครื่องฟอกอากาศปิดอยู่ขะไม่สามารถอ่านฝุ่นได้จึงคืนค่า 0 ไป

ค่าที่ส่งกลับ (Return): double (ค่าฝุ่น PM2.5 ปัจจุบัน) / 0

13.getModel()
    ข้อมูลนำเข้า (Inputs): ไม่มี

ภาพรวมการทำงาน: ดึงชื่อรุ่นของเครื่องฟอกอากาศจากตัวแปร model

ค่าที่ส่งกลับ (Return): String (ชื่อรุ่นของเครื่อง)

14.getRoomVolume()
    ข้อมูลนำเข้า (Inputs): ไม่มี

ภาพรวมการทำงาน: ดึงค่าปริมาตรห้องจากตัวแปร roomVolume

ค่าที่ส่งกลับ (Return): double (ปริมาตรของห้อง)

15.getTotalPurifiers()
    ข้อมูลนำเข้า (Inputs): ไม่มี

ภาพรวมการทำงาน: ดึงค่าจำนวนเครื่องฟอกอากาศทั้งหมดที่ถูกสร้างขึ้นจากตัวแปรแบบสแตติก totalPurifiers

ค่าที่ส่งกลับ (Return): int (จำนวนเครื่องฟอกอากาศทั้งหมดในระบบ)


