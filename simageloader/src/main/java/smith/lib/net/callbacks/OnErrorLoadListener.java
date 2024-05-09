package smith.lib.net.callbacks;

import smith.lib.net.exceptions.LoadImageException;

/**
 * Fail load image callback.
 * @since 1.0.0
 * @author <a href="https://t.me/smithdev">Hussein Shakir</a>
 */
public interface OnErrorLoadListener {

    /**
     * Fail load image callback.
     * @param error The error object when the error occurred.
     * @since 1.0.0
     * @author <a href="https://t.me/smithdev">Hussein Shakir</a>
     */
    void onError(LoadImageException error);
}
