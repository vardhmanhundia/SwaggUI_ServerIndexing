package com.kaibur.mongodb.serverindex.serverindex;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/server")
@Api(value="Server Indexing", tags = {"springboot", "docker", "reactApp", "spring-data-mongoDB"})
public class ServerController {

    @Autowired
    private ServerRepository repository;
    @Autowired
    private MongoOperations mongoOps;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    //for fetching all the servers in the database
    @ApiOperation(value = "fetching all the servers",response = Server.class)
    @GetMapping("/")
    public List<Server> getServers() {
        return repository.findAll();
    }

    //for fetching server with serverId in the database
    @ApiOperation(value = "Search for exisiting server with an serverID",response = Server.class)
    @GetMapping("/{id}")
    public Server getServer(@PathVariable long id) {
        Optional<Server> server = repository.findById(id);
        if(server.isPresent()){
            return server.get();
        }
        else
        {
            throw new ApiRequestException("No server with id found");
        }
    }

    //for fetching all the servers with serverName having name attribute in the string from the database
    @ApiOperation(value = "Search for exisiting server with serverName having name attribute in the string ",response = Server.class)
    @GetMapping("/search/{name}")
    public List<Server> searchServer(@PathVariable String name) {

        Query query = new Query();
        String string  = String.format(".*%s.*",name);
        query.addCriteria(Criteria.where("serverName").regex( string,"i"));
        List<Server> servers = mongoOps.find(query, Server.class);

        if(servers.size()==0) {
            throw new ApiRequestException("No such server available");
        }else{
            return servers;
        }
    }

    //for deleting server with specific serverId from the database
    @ApiOperation(value = "Deleting server with specific serverId",response = Server.class)
    @DeleteMapping("/{id}")
    public String deleteServer(@PathVariable long id) {
        repository.deleteById(id);
        return "Server Deleted with id: "+ id;
    }

    //for deleting servers with List of specific server Ids from the database
    @ApiOperation(value = "Deleting multiple servers with List of specific server Ids",response = Server.class)
    @DeleteMapping("/deleteMultiple")
    public String deleteMultipleServers(@RequestBody List<Long> ids) {
        for(Long id: ids){
            repository.deleteById(id);
        }
        return "Listed servers were been Deleted";
    }

    //for adding a server to the database
    @ApiOperation(value = "Adding a server",response = Server.class)
    @PostMapping("/add")
    public String addServer(@RequestBody Server server) {
        server.setId(sequenceGeneratorService.generatedSequence(server.SEQUENCE_NAME));
        repository.insert(server);
        return "Added server with id: " + server.getId();
    }

    //for adding multiple servers to the database
    @ApiOperation(value = "Adding multiple servers",response = Server.class)
    @PostMapping("/addMultiple")
    public String addMultipleServer(@RequestBody List<Server> servers) {
        for(Server i:servers){
            i.setId(sequenceGeneratorService.generatedSequence(i.SEQUENCE_NAME));
            repository.insert(i);
        }
        return "Added elements to the server ";
    }

    //for updating server with serverId in the database
    @ApiOperation(value = "Updating server with serverId",response = Server.class)
	@PutMapping("/update")
	public String updateServer(@RequestBody Server server) {
        repository.save(server);
        return "The server data with id"+ server.getId();
    }

    //for updating multiple servers in the database
    @ApiOperation(value = "Updating multiple servers",response = Server.class)
    @PutMapping("/updateMultiple")
    public String updateMultipleServer(@RequestBody List<Server> servers) {
        for(Server i:servers) {
            repository.save(i);
        }
        return "The servers were updated successfully";
    }
}
