package ru.yandex.qatools.allure.events;

import ru.yandex.qatools.allure.model.Status;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 11.11.13
 */
public class TestCaseFailureEvent extends TestCaseStatusChangeEvent {

    @Override
    protected Status getStatus() {
        return throwable instanceof AssertionError ? Status.FAILED : Status.BROKEN;
    }

    @Override
    protected String getMessage() {
        return getStatus() == Status.FAILED ? "Test failed with unknown reason" : "Test broken with unknown reason";
    }

    @Override
    public TestCaseStatusChangeEvent withThrowable(Throwable value) {
        setThrowable(value);
        return this;
    }
}