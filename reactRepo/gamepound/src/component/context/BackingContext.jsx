import React, { createContext, useContext, useEffect, useState, useTransition } from 'react';
import { useUserMemory } from './UserContext';

const BackingMemory = createContext();

const useBackingMemory = () => {
    const obj = useContext(BackingMemory);
    return obj;
}

const BackingMemoryProvider = ({children}) => {

    // useContext - loginMember
    const {loginMemberVo} = useUserMemory();
    
    const [dataVo, setDataVo] = useState([]);
    
    // 프로젝트 정보, 후원 정보 fetch
    const loadBackingFormInfo = () => {
        fetch("http://127.0.0.1:8889/gamepound/back/process")
        .then(resp => {return resp.json()})
        .then(data => {
            setDataVo({
                ...data,
                "memberNo": loginMemberVo.no,
                "memberEmail": loginMemberVo.email,
            });
        })
        ;
    }
    
    // 렌더링 1번만
    useEffect(()=>{
        if(loginMemberVo !== undefined) {
            loadBackingFormInfo();
        }
    }, [loginMemberVo])

    // dataVo, setDataVo 객체 1개로 합치기
    const dataSet = {
        dataVo,
        setDataVo
    }
    
    return (
        <BackingMemory.Provider value={dataSet}>
            {children}
        </BackingMemory.Provider>
    );
};

export {useBackingMemory, BackingMemoryProvider};