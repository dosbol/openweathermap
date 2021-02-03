# openweathermap

Using the OpenWeatherMap API get the current weather and the 5 day forecast for the
following European cities:
- Athens, Greece
- Paris, France
- London, UK
- Madrid, Spain
- Moscow, Russia  
- Rome, Italy

The job will need to run as a jar file and depending on the parameter passed to it either execute the current weather or the 5 day forecast extract. Once the data is returned, it should be flattened and converted to a csv before loading into the relevant table.


## Usage

FIXME: set env variable OPENWEATHERMAP_API_KEY

    $ make test
    $ make build
    $ make run (current weather)
    $ make run-5 (5 day forecast)
