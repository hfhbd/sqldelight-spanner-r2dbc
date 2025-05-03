package app.softwork.spanner

import app.cash.sqldelight.async.coroutines.*
import app.cash.sqldelight.driver.r2dbc.*
import com.google.cloud.spanner.r2dbc.*
import com.google.cloud.spanner.r2dbc.v2.*
import io.r2dbc.spi.ConnectionFactoryOptions
import kotlinx.coroutines.*
import kotlinx.coroutines.reactive.*

suspend fun main(vararg args: String) = coroutineScope {
    val (sampleProjectId, sampleInstance, sampleDatabase) = args

    val connectionFactory = SpannerClientLibraryConnectionFactory(
        SpannerConnectionConfiguration.Builder(
            ConnectionFactoryOptions.builder().build()
        )
            .setDatabaseName(sampleDatabase)
            .setProjectId(sampleProjectId)
            .setInstanceName(sampleInstance)
            .build()
    )

    val driver = R2dbcDriver(connectionFactory.create().awaitSingle())
    val spanner = Spanner(driver)

    for (customer in spanner.financeQueries.getAllCustomers().awaitAsList()) {
        println(customer)
    }

    for (foo in spanner.fooQueries.getAll().awaitAsList()) {
        println(foo)
    }
    spanner.fooQueries.insert(Foo(42, "adam"))

    for (foo in spanner.fooQueries.getAll().awaitAsList()) {
        println(foo)
    }
}
