import React, { useEffect, useState } from 'react';
import {styled} from 'styled-components';
import ProjectBriefInfo from '../../component/project/ProjectBriefInfo';
import BackingForm from '../backingpage/BackingForm';

const StyledBackingFormDiv = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: start;
    align-items: center;
`;

const BackingProcess = () => {

    const [dataProjectVo, setDataProjectVo] = useState({});
    const [dataBackVo, setDataBackVo] = useState({});

    // 프로젝트 정보, 후원 정보 fetch
    const loadBackingFormInfo = () => {
        fetch("http://127.0.0.1:8889/gamepound/back/process")
        .then(resp => {return resp.json()})
        .then(data => {
            setDataProjectVo(data);

            // 후원자 이메일 정보 채우기
            // 세션스토리지에서 로그인 멤버 값 가져와서 dataVo에 넣기
            data.memberEmail = sessionStorage.getItem("loginMemberVo");
            setDataBackVo(data);
        })
        ;
    }

    // 렌더링 1번만
    useEffect(()=>{
        loadBackingFormInfo();
    }, [])


    return (
        <StyledBackingFormDiv>
            <ProjectBriefInfo ProjectBriefInfo={dataProjectVo}/>
            <BackingForm BackingInfo={dataBackVo}/>
        </StyledBackingFormDiv>
    );
};

export default BackingProcess;