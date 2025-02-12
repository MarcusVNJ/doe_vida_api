package com.doevida.infrastructure.out.port;

import java.util.List;

public interface BulkInsertRepository<T> {

    public void insertAll(List<T> obj);

}
