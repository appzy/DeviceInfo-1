package ltns.deviceinfolib.collector;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;

import ltns.deviceinfolib.collector.base.BaseDeviceInfoCollector;

/**
 * @date 创建时间：2018/1/8
 * @author appzy
 * @Description NFC信息
 * @version
 */

public class NfcInfoCollector extends BaseDeviceInfoCollector {
    public NfcInfoCollector(Context context, String collectorName) {
        super(context, collectorName);
    }

    //是否支持nfc
    private static final String NFC_SUPPORT = "nfcSupport";

    @Override
    public boolean needCollectManually() {
        return false;
    }

    @Override
    public String[] getRequiredPermissions() {
        return new String[0];
    }

    @Override
    protected void doCollectAutomatically() {
        put(NFC_SUPPORT, checkNfcSupport());
    }

    private boolean checkNfcSupport() {
        NfcManager nfcManager = (NfcManager) mContext.getSystemService(Context.NFC_SERVICE);
        NfcAdapter adapter = nfcManager.getDefaultAdapter();
        return adapter != null;
    }

    @Override
    protected void doCollectManually() {

    }
}
