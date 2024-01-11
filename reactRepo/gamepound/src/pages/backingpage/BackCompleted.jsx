import React, { useEffect, useState } from 'react';
import styled from 'styled-components';

const StyledBackCompletedDiv = styled.div`
    height: 400px;
    font-size: 32px;
    display: flex; 
    flex-direction: column;
    align-items: center;
    margin-top: 100px;
`;

const BackCompleted = () => {

    // 유효성 체크 TODO
    // 후원하기를 거치지 않고 들어왔을 때 알람 띄우고 navigate


    const [nthBacker, setNthBacker] = useState('');

    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/back/completed")
        .then(resp => resp.json())
        .then(data => {
            setNthBacker(data);
        });
        
    }, [])


    return (
        <StyledBackCompletedDiv>
            <div>축하합니다. {nthBacker}번째</div>
            <div>공식후원자가 되셨습니다!</div>
        </StyledBackCompletedDiv>
    );
};

export default BackCompleted;