import React, { createContext, useContext, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

const UserPageContext = createContext();

const useUserPageContext = () => {
    const obj = useContext(UserPageContext);
    return obj;
}

const UserPageContextProvider = ({children}) => {

    const [profileVo, setProfileVo] = useState([]);

    const {no} = useParams();

    useEffect(()=> {
        fetch("http://127.0.0.1:8889/gamepound/userpage/profile?memberNo="+no)
        .then(resp => resp.json())
        .then(data => {
            setProfileVo(data);
        })
    }, []);

    return (
        <UserPageContext.Provider value={{profileVo, setProfileVo}}>
            {children}
        </UserPageContext.Provider>
    );
};

export {useUserPageContext, UserPageContextProvider};