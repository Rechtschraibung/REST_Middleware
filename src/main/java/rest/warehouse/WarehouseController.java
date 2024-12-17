package rest.warehouse;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import rest.model.WarehouseData;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    private WarehouseSimulation wsim = new WarehouseSimulation();

    @GetMapping(value = "/{lghID}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public WarehouseData getWarehouseDataJSON(@PathVariable String lghID) {
        return wsim.getData(lghID);
    }

    @GetMapping(value = "/{lghID}/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public WarehouseData getWarehouseDataXML(@PathVariable String lghID) {
        return wsim.getData(lghID);
    }
}
