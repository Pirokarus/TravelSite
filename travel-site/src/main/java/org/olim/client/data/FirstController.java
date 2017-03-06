package org.olim.client.data;


import javax.inject.Inject;

public class FirstController {

    private static FirstModel firstModel;

    @Inject
    public FirstController(FirstModel firstModel){
        this.firstModel = firstModel;
        firstModel.addFirstModelComandHandler(new MyFirstModelCommandHandler());

    }

    private class MyFirstModelCommandHandler implements FirstModelLoadCommandHandler {

        @Override
        public void onFirstModelLoadComand(FirstModelLoadCommand command) {

            firstModel.setData("olim");

        }
    }
}
