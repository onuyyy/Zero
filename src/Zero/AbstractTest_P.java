package Zero;// 아래 Zero.Device 추상 클래스를 이용하여
// Zero.UsbPort1 클래스와 Zero.Wifi 클래스를 자유롭게 구현하라.

abstract class Device {
    int deviceId;

    abstract void deviceInfo();
    abstract void connect();
    abstract void disconnect();
    abstract void send();
    abstract void receive();
}

class UsbPort1 extends Device {
    UsbPort1(int id) {
        this.deviceId = id;
    }
    @Override
    void deviceInfo() {
        System.out.println("Zero.Device 정보 : "+ deviceId);
    }

    @Override
     void connect() {
        System.out.println("연결 완료");
    }

    @Override
    void disconnect() {
        System.out.println("연결 해제");
    }

    @Override
    void send() {
        System.out.println("발신");
    }

    @Override
    void receive() {
        System.out.println("수신");
    }
}

class Wifi extends Device {
    Wifi(int id) {
        this.deviceId = id;
    }

    @Override
    void deviceInfo() {

    }

    @Override
    void connect() {

    }

    @Override
    void disconnect() {

    }

    @Override
    void send() {

    }

    @Override
    void receive() {

    }
}

public class AbstractTest_P {
    public static void main(String[] args) {
        UsbPort1 usb = new UsbPort1(354);
        usb.deviceInfo();

        Wifi w = new Wifi(234);
    }
}
