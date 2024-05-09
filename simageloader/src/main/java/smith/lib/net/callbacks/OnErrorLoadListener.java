package smith.lib.net.callbacks;

import smith.lib.net.exceptions.LoadImageException;

public interface OnErrorLoadListener {

    void onError(LoadImageException error);
}
