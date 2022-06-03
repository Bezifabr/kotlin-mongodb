import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClients

fun main() {
    println("Hello World!")

    val username = ""
    val password = ""
    val hostname = ""
    val databaseName = ""
    val collectionName = ""

    val connectionString =
        ConnectionString("mongodb+srv://${username}:${password}@${hostname}/?retryWrites=true&w=majority")
    val settings: MongoClientSettings = MongoClientSettings.builder()
        .applyConnectionString(connectionString)
        .build()
    val mongoClient = MongoClients.create(settings)
    val database = mongoClient.getDatabase(databaseName)
    val collection = database.getCollection(collectionName)

    val cursor = collection.find()

    for (document in cursor) {
        println(document)
    }

    // Inserting new document
//    val document = Document()
//    document["name"] = "test5"
//    collection.insertOne(document)

}