import React, {useState, useEffect} from 'react';
import Item from "../Components/Item/Item";
import './CSS/Inventory.css';
import CategoryBar from "../Components/CategoryBar/CategoryBar";
import AdvancedSearch from '../Components/AdvancedSearch/AdvancedSearch'
import carImages from '../Components/Assets/images/carImages'
import {fetchCarsData} from '../Components/Assets/fetchCarData';

const getImageFromDbString = (imageName) => {
    return carImages[imageName] || null;
};

const Inventory = ({searchTerm, allCars}) => {

    const [makes, setMakes] = useState(new Set());
    const [make, setMake] = useState("all");
    const [category, setCategory] = useState("all");
    const [showAdvancedSearch, setShowAdvancedSearch] = useState(false);
    const [yearFrom, setYearFrom] = useState('');
    const [yearTo, setYearTo] = useState('');
    const [priceLowest, setPriceLowest] = useState('');
    const [priceHighest, setPriceHighest] = useState('');
    const [transmission, setTransmission] = useState('');
    const [odometerMin, setOdometerMin] = useState('');
    const [odometerMax, setOdometerMax] = useState('');

    useEffect(() => {
        const carMakes = new Set(allCars.map(car => car.make));
        setMakes(carMakes);
    }, [allCars]);

    const convertPrice = (priceStr) => parseFloat(priceStr.replace(/,/g, ''));

    const filteredCars = allCars.filter(item => {
        const itemPrice = convertPrice(item.price);
        const itemTransmission = item.transmission ? item.transmission.toLowerCase() : '';

        const searchFilter = searchTerm === '' || item.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
            item.location.toLowerCase().includes(searchTerm.toLowerCase()) || item.make.toLowerCase().includes(searchTerm.toLowerCase()) ||
            item.model.toLowerCase().includes(searchTerm.toLowerCase());

        return (
            searchFilter &&
            (make === "all" || item.make === make) &&
            (category === "all" || item.categories.includes(category)) &&
            (yearFrom === '' || item.year >= parseInt(yearFrom)) &&
            (yearTo === '' || item.year <= parseInt(yearTo)) &&
            (priceLowest === '' || itemPrice >= parseFloat(priceLowest)) &&
            (priceHighest === '' || itemPrice <= parseFloat(priceHighest)) &&
            (transmission === '' || itemTransmission === transmission.toLowerCase()) &&
            (odometerMin === '' || item.odometer >= parseFloat(odometerMin)) &&
            (odometerMax === '' || item.odometer <= parseFloat(odometerMax))
        );
    });

    const toggleAdvancedSearch = () => {
        setShowAdvancedSearch(prevState => !prevState);
    };

    return (
        <div className="inventory">
            <CategoryBar category={category} setCategory={setCategory} makes={makes} setMake={setMake} make={make}/>

            <div className="right-side">

                <div className="advanced-search" onClick={toggleAdvancedSearch}>
                    <p>ADVANCED SEARCH {showAdvancedSearch ? '▲' : '▼'}</p>
                </div>

                {showAdvancedSearch &&
                    <AdvancedSearch yearFrom={yearFrom} yearTo={yearTo} setYearFrom={setYearFrom} setYearTo={setYearTo}
                                    priceLowest={priceLowest} priceHighest={priceHighest}
                                    setPriceLowest={setPriceLowest} setPriceHighest={setPriceHighest}
                                    transmission={transmission} setTransmission={setTransmission}
                                    odometerMin={odometerMin}
                                    odometerMax={odometerMax} setOdometerMax={setOdometerMax}
                                    setOdometerMin={setOdometerMin}/>
                }

                <div className="items">
                    {filteredCars.map((item, i) => {

                        return (
                            <Item
                                key={i}
                                id={item.id}
                                name={item.name}
                                image={getImageFromDbString(item.images[0])}
                                price={item.price}
                            />
                        );

                    })}
                </div>

            </div>
        </div>
    );
}

export default Inventory;
