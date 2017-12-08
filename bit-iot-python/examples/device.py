import serial
import time
ser = serial.Serial("/dev/ttyACM0")
time.sleep(5)
print("start....")

while True:
    print(ser.readline())
    print("------------------------------------")