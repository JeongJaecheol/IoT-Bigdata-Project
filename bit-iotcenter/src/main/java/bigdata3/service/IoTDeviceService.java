package bigdata3.service;

import java.util.List;

import bigdata3.domain.IoTDevice;

public interface IoTDeviceService {
  List<IoTDevice> list(int pageNo, int pageSize);
  void add(IoTDevice device);
  IoTDevice get(String serialNo);
  void changeOwner(IoTDevice device);
  void remove(String serialNo);
}
