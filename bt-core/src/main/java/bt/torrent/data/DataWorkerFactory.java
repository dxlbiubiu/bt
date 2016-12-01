package bt.torrent.data;

import bt.data.IDataDescriptor;
import bt.service.IRuntimeLifecycleBinder;

/**
 *<p><b>Note that this class implements a service.
 * Hence, is not a part of the public API and is a subject to change.</b></p>
 */
public class DataWorkerFactory implements IDataWorkerFactory {

    private IRuntimeLifecycleBinder lifecycleBinder;
    private int maxIOQueueSize;

    public DataWorkerFactory(IRuntimeLifecycleBinder lifecycleBinder, int maxIOQueueSize) {
        this.lifecycleBinder = lifecycleBinder;
        this.maxIOQueueSize = maxIOQueueSize;
    }

    @Override
    public IDataWorker createWorker(IDataDescriptor dataDescriptor) {
        return new DataWorker(lifecycleBinder, dataDescriptor, maxIOQueueSize);
    }
}
