package bigdata3.service;

import java.util.List;

import bigdata3.domain.Device;

public interface DeviceService {
  List<Device> list(String fbUserId, String deviceType);
}
