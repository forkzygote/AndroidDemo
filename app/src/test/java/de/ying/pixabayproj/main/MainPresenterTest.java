package de.ying.pixabayproj.main;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import de.ying.pixabayproj.mvp.Presenter.MainPresenter;
import de.ying.pixabayproj.mvp.View.MainView;

import static org.mockito.Mockito.verify;

/**
 * author : yingli
 * time   : 8/19/17
 * desc   : Unit tests for the implementation of {@link de.ying.pixabayproj.mvp.Presenter.MainPresenter}
 */

public class MainPresenterTest {

    @Mock
    private MainView mMainView;

    private MainPresenter mMainPresenter;

    @Before
    public void setupMainPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        mMainPresenter = new MainPresenter();
        mMainPresenter.setView(mMainView);
    }

    @Test
    public void clickOnDialog_ShowHitDetail(){
        int position = new Random().nextInt(20);
        mMainPresenter.openHitDetail(position);
        verify(mMainView).openHitDetailUtil(position);

    }
}
